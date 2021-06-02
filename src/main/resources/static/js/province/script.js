
function getView(id) {
    $(document).ready( function () {
            $.ajax({
                url: `http://localhost:8080/ui/provinces/get/${id}`
            }).then(function (data) {
                console.log(JSON.stringify(data));
                $('.view-id').html(data.id);
                $('.view-name').html(data.name);
                $('.view-phone-code').html(data.phoneCode);
                $('.view-state').html(data.state);
                var createdAt = new Date(data.created_at);
                $('.view-created-at').html(createdAt.toLocaleString('uk-UA'));
                var modifiedAt = new Date(data.modified_at);
                $('.view-modified-at').html(modifiedAt.toLocaleString('uk-UA'));
                var description = data.description === null ? '&mdash;' : data.description;
                $('.view-description').html(description);
            }).then(function () {
                $('#ModalView').modal('show');
            })
        }
    );
}

function getUpdate(id) {
    $(document).ready( function () {
            $.ajax({
                url: `http://localhost:8080/ui/provinces/get/${id}`
            }).then(function (data) {
                $('#update-form').attr('action', `http://localhost:8080/ui/provinces/update/${data.id}`)
                $( "input[name='update-id']" ).val(data.id);
                $( "input[name='update-name']" ).val(data.name);
                $( "input[name='update-phone-code']" ).val(data.phoneCode);
                $( "select[name='update-state']" ).val(data.state);
                $( "textarea[name='update-description']" ).val(data.description);
            }).then(function () {
                $('#ModalUpdateForm').modal('show');
            })
        }
    );
}

function getDelete(id) {
    $("#delete-province").attr('href', `http://localhost:8080/ui/provinces/delete/${id}`);
    $("#ModalDelete").modal('show');
}