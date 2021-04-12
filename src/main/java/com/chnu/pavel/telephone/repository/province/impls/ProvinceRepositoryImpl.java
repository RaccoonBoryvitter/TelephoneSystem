package com.chnu.pavel.telephone.repository.province.impls;

import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import com.chnu.pavel.telephone.repository.province.interfaces.ProvinceRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceRepositoryImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 04.04.2021|21:47
 * @Version ProvinceRepositoryImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class ProvinceRepositoryImpl implements ProvinceRepository {

    private final MongoClient mongoClient;

    @Override
    public Province create(Province province) {
        mongoClient.getDatabase("cityTelephoneExchangeDB")
                .getCollection("provinces")
                .insertOne(toDocument(province));

        return getByName(province.getName());
    }

    @Override
    public Province getById(String id) {
        return mongoClient.getDatabase("cityTelephoneExchangeDB")
                .getCollection("provinces")
                .find(new Document("_id", new ObjectId(id)))
                .map(this::toProvince)
                .first();
    }

    @Override
    public Province getByName(String name) {
        return mongoClient.getDatabase("cityTelephoneExchangeDB")
                .getCollection("provinces")
                .find(new Document("name", name))
                .map(this::toProvince)
                .first();
    }

    @Override
    public Province getByState(String state) {
        return mongoClient.getDatabase("cityTelephoneExchangeDB")
                .getCollection("provinces")
                .find(new Document("state", state))
                .map(this::toProvince)
                .first();
    }

    @Override
    public Province updateById(Province province, String id) {
        mongoClient.getDatabase("cityTelephoneExchangeDB")
                .getCollection("provinces")
                .updateOne(
                        Filters.eq("_id", new ObjectId(id)),
                        Updates.combine(
                                Updates.set("name", province.getName()),
                                Updates.set("phoneCode", province.getPhoneCode()),
                                Updates.set("state", province.getState().name())
                        )
                );

        return getById(id);
    }

    @Override
    public String deleteById(String id) {
        return "Object(s) was/were deleted: " +
                mongoClient.getDatabase("cityTelephoneExchangeDB")
                .getCollection("provinces")
                .deleteOne(new Document("_id", new ObjectId(id)))
                .getDeletedCount();
    }

    @Override
    public List<Province> getAll() {
        return mongoClient.getDatabase("cityTelephoneExchangeDB")
                .getCollection("provinces")
                .find()
                .map(this::toProvince)
                .into(new ArrayList<>());
    }

    private Province toProvince(Document obj) {
        return Province.builder()
                .id(((ObjectId)obj.get("_id")).toString())
                .name(obj.get("name").toString())
                .phoneCode(obj.get("phoneCode").toString())
                .state(State.valueOf(obj.get("state").toString()))
                .build();
    }

    private static Document toDocument(Province province) {
        return new Document("name", province.getName())
                .append("phoneCode", province.getPhoneCode())
                .append("state", province.getState().name());
    }

}
