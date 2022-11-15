$(function(){
    $("form").submit(formSubmit);
});
function formSubmit(event){
    event.preventDefault();
    requestWithArgs(getX(), getY());
}
function getX(){
    return parseFloat($("#xValue").val());
}
function getR(){
    return parseFloat($("#rValue").val());
}
function getY(){
    return parseFloat($("#y").val());
}

function requestWithArgs(xArg, yArg) {
    $.ajax({
        url: "controller",
        type: "POST",
        data: {x: xArg, y: yArg, r: getR()},
        success: function (data) {
            window.location.replace("table.jsp");
        },
        error: function(){
            window.location.replace("error.jsp");
        }
    });
}




