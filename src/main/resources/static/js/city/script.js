function getView(id) {
    $(document).ready( function () {
            $.ajax({
                url: `http://localhost:8080/ui/cities/get/${id}`
            }).then(function (data) {
                $('.view-id').html(data.id);
                $('.view-name').html(data.name);
                $('.view-phone-code').html(data.phoneCode);
                $('.view-province').html(`<a href="/ui/provinces/#${data.province.id}">${data.province.name}</a>`);
            }).then(function () {
                $('#ModalView').modal('show');
            })
        }
    );
}

function getUpdate(id) {
    $(document).ready( function () {
            $.ajax({
                url: `http://localhost:8080/ui/cities/get/${id}`
            }).then(function (data) {
                $('#update-form').attr('action', `http://localhost:8080/ui/cities/update/${data.id}`)
                $( "input[name='update-id']" ).val(data.id);
                $( "input[name='update-name']" ).val(data.name);
                $( "input[name='update-phone-code']" ).val(data.phoneCode);
                $( "select[name='update-province']" ).val(data.province.name);
            }).then(function () {
                $('#ModalUpdateForm').modal('show');
            })
        }
    );
}

function getDelete(id) {
    $("#delete-province").attr('href', `http://localhost:8080/ui/cities/delete/${id}`);
    $("#ModalDelete").modal('show');
}