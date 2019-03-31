/**
 * 
 */

$(function () {
    
    $("#roomsfile").on("change", function (e) {
        var imageNames = e.target.files;
        var imageNameArr = Array.prototype.slice.call(imageNames);
        if(imageNameArr[0]==null){
            $("#hiddenPicture").html("");
            return;
        }
        var reader = new FileReader();
        imageNameArr.forEach(function (f) {
            if (!f.type.match("image.*")) {
                alert("사진은 이미지만 가능합니다.");
                $("#roomsfile").val("");
                $("#hiddenPicture").html("");
                return;
            }
            var sel_file = f;

            reader.onload = function (e) {
                $("#hiddenPicture").html("<img src = '" + e.target.result + "' width='278px' height= '250px' style = 'border:1px solid black;'>");
            }

            reader.readAsDataURL(f)

        });


    });
})