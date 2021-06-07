function getView(id) {
    $(document).ready( function () {
            $.ajax({
                url: `/cities/get/${id}`
            }).then(function (data) {
                console.log(JSON.stringify(data));
                $('.view-id').html(data.id);
                $('.view-name').html(data.name);
                $('.view-phone-code').html(data.phoneCode);
                $('.view-province').html(data.province.name);
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
                url: `/cities/get/${id}`
            }).then(function (data) {
                $('#update-form').attr('action', `/cities/update/${data.id}`)
                $( "input[name='update-id']" ).val(data.id);
                $( "input[name='update-name']" ).val(data.name);
                $( "input[name='update-phone-code']" ).val(data.phoneCode);
                $( "select[name='update-province']" ).val(data.province.id);
                $( "textarea[name='update-description']" ).val(data.description);
            }).then(function () {
                $('#ModalUpdateForm').modal('show');
            })
        }
    );
}

function getDelete(id) {
    $("#delete-province").attr('href', `/cities/delete/${id}`);
    $("#ModalDelete").modal('show');
}