package com.chnu.pavel.telephone.repository.city.impls;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityRepositoryImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|19:27
 * @Version CityRepositoryImpl: 1.0
 */

@Component
@AllArgsConstructor
public class CityRepositoryImpl implements CityRepository {

    private final MongoClient mongoClient;

    @Override
    public City create(City city) {
        mongoClient.getDatabase("cityTelephoneExchangeDB")
                   .getCollection("cities")
                   .insertOne(toDocument(city));

        return getByName(city.getName());
    }

    @Override
    public City getById(String id) {
        return mongoClient.getDatabase("cityTelephoneExchangeDB")
                          .getCollection("cities")
                          .aggregate(Arrays.asList(
                                  Aggregates.match(new Document("_id", id)),
                                  Aggregates.lookup("provinces", "province.$id", "_id", "province"),
                                  Aggregates.unwind("$province")
                                  )
                          )
                          .map(this::toCity)
                          .first();
    }

    @Override
    public City getByName(String name) {
        return mongoClient.getDatabase("cityTelephoneExchangeDB")
                          .getCollection("city")
                          .find(new Document("name", name))
                          .map(this::toCity)
                          .first();
    }

    @Override
    public City updateById(City city, String id) {
        mongoClient.getDatabase("cityTelephoneExchangeDB")
                   .getCollection("cities")
                   .updateOne(
                           Filters.eq("_id", new ObjectId(id)),
                           Updates.combine(
                                   Updates.set("name", city.getName()),
                                   Updates.set("phoneCode", city.getPhoneCode()),
                                   Updates.set("province", new Document("$ref", "provinces")
                                           .append("$id", city.getProvince().getId()))
                           )
                   );

        return getById(id);
    }

    @Override
    public String deleteById(String id) {
        return "Object(s) was/were deleted: " +
                mongoClient.getDatabase("cityTelephoneExchangeDB")
                           .getCollection("cities")
                           .deleteOne(new Document("_id", new ObjectId(id)))
                           .getDeletedCount();
    }

    @Override
    public List<City> getCities() {
        return mongoClient.getDatabase("cityTelephoneExchangeDB")
                          .getCollection("cities")
                          .aggregate(Arrays.asList(
                                        Aggregates.lookup("provinces", "province.$id", "_id", "province"),
                                        Aggregates.unwind("$province")
                                  )
                          )
                          .into(new ArrayList<>())
                          .stream()
                          .map(this::toCity)
                          .collect(Collectors.toList());
    }

    private City toCity(Document obj) {
        Document thisProvince = (Document) obj.get("province");

        return City.builder()
                .id(obj.get("_id").toString())
                .name(obj.get("name").toString())
                .phoneCode(obj.get("phoneCode").toString())
                .province(Province.builder()
                                  .id(((ObjectId)thisProvince.get("_id")).toString())
                                  .name(thisProvince.get("name").toString())
                                  .phoneCode(thisProvince.get("phoneCode").toString())
                                  .state(State.valueOf(thisProvince.get("state").toString()))
                                  .build())
                .build();
    }

    private static Document toDocument(City city) {
        return new Document("name", city.getName())
                .append("phoneCode", city.getPhoneCode())
                .append("province",
                        new Document("$ref", "provinces")
                                .append("$id", city.getProvince().getId()));
    }
}
