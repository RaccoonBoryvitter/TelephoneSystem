<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create province</title>
</head>
<body>

<div style="width: 25%">
    <fieldset>
        <legend>Add province</legend>
        <@spring.bind "states" />
        <form name="province" action="" method="POST">
            Name of province:<@spring.formInput path="provinceForm.name" attributes="" fieldType="text"/>
            <br>
            Phone Code:<@spring.formInput path="provinceForm.phoneCode" attributes="" fieldType="text"/>
            <br>
            State:<@spring.formSingleSelect path="provinceForm.state" options=states attributes=""/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>