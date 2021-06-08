$("button").on('submit', function () {
    $(".loader").css('display', 'flex');
    $(".loader").fadeIn();
})

$("a:not(.alert-close)").on('click', function () {
    $(".loader").css('display', 'flex');
    $(".loader").fadeIn();
});
