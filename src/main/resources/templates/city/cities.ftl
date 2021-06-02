<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cities</title>
    <link rel="stylesheet" href="/css/icons/all.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="/css/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="/js/city/script.js"></script>
</head>
<body>

<h1>Cities</h1>

<table>
    <tr>
        <th>Name</th>
        <th>Phone Code</th>
        <th>Province</th>
        <th>Actions</th>
    </tr>
    <#list items as item>
        <tr>
            <td>${item.name}</td>
            <td>${item.phoneCode}</td>
            <td><a href="/ui/provinces/#${item.province.id}">${item.province.name}</a></td>
            <td>
                <i onclick="getView('${item.id}')" class="far fa-eye"></i>
                <i onclick="getUpdate('${item.id}')" class="far fa-edit"></i>
                <i onclick="getDelete('${item.id}')" class="far fa-trash-alt"></i>
            </td>
        </tr>
    </#list>
    <tr>
        <td colspan="4">
            <button id="create-modal-button" data-toggle="modal"
                    data-target="#ModalCreateForm">+ Create</button>
        </td>
    </tr>
</table>

<#--Create-->
<div id="ModalCreateForm" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Add City</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="create-form" role="form" method="POST" action="/ui/cities/create/">
                    <input type="hidden" name="_token" value="">
                    <div class="form-group">
                        <label class="control-label">City Name</label>
                        <div>
                            <input type="text" class="form-control input-lg"
                                   name="create-name" placeholder="Name..." pattern="[A-Za-z[#\-]{0,2}]{5,30}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Phone Code</label>
                        <div>
                            <input type="text" name="create-phone-code"
                                   class="form-control input-lg" placeholder="e.g. 45" pattern="[0-9]{1,2}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Province</label>
                        <div>
                            <select name="create-province" class="custom-select" required>
                                <#list provinces as province>
                                    <option value="${province.id}">${province.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="submit" class="btn btn-success">Create</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<#--Update-->
<div id="ModalUpdateForm" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Update Existing City</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="update-form" role="form" method="POST" action="">
                    <input type="hidden" name="_token" value="">
                    <div class="form-group">
                        <label class="control-label">ID</label>
                        <div>
                            <input type="text" class="form-control input-lg" name="update-id" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">City Name</label>
                        <div>
                            <input type="text" class="form-control input-lg"
                                   name="update-name" placeholder="Name..." pattern="[A-Za-z[#\-]{0,2}]{5,30}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Phone Code</label>
                        <div>
                            <input type="text" name="update-phone-code"
                                   class="form-control input-lg" placeholder="e.g. 45" pattern="[0-9]{2,3}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Province</label>
                        <div>
                            <select name="update-province" class="custom-select" required>
                                <#list provinces as province>
                                    <option value="${province.id}">${province.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="submit" class="btn btn-success">Update</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<#--Delete-->
<div id="ModalDelete" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Delete City</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h2>Are you sure?</h2>
                <p>Do you want to delete this city?</p>
                <p class="undone">This cannot be undone.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <a id="delete-province" href="" class="btn btn-danger">Delete</a>
            </div>
        </div>
    </div>
</div>

<#--Read-->
<div id="ModalView" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">View Details</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div>
                    <h4><b>ID</b></h4>
                    <h5 class="view-id"></h5>
                </div>
                <div>
                    <h4><b>Name</b></h4>
                    <h5 class="view-name"></h5>
                </div>
                <div>
                    <h4><b>Phone Code</b></h4>
                    <h5 class="view-phone-code"></h5>
                </div>
                <div>
                    <h4><b>Province</b></h4>
                    <h5 class="view-province"></h5>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>