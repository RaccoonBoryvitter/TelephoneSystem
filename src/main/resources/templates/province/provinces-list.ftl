<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/css/styles.css">
</head>
<body>

        <table class="table-bordered">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone Code</th>
                <th>State</th>
                <th></th>
            </tr>
            <#list items as item>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.phoneCode}</td>
                    <td>${item.state}</td>
                    <td>
                        <a href="/ui/provinces/delete/${item.id}"><button type="button">Delete</button></a>
                    </td>
                </tr>
            </#list>
            <tr>
                <button>
                    <a href="/ui/provinces/create/"><button type="button">Create...</button></a>
                </button>
            </tr>
        </table>

</body>
</html>