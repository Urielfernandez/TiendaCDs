$("#filtrar").click(function(){
    $(".itemCd").hide();
    $("." + $("#pais").val()).show();
})