window.onload=function(){
    console.log(1);
    document.onkeydown = function (event) {
        var event = event || window.event;
        var code = event.keyCode || event.which;
        var x=document.getElementById("invisible");
        switch (code) {
            case 49:
                return x.value = 1;
                break;
            case 50:
                return x.value = 2;
                break;
            case 51:
                return x.value = 3;
                break;
            case 52:
                return x.value = 4;
                break;
            case 53:
                return x.value = 5;
                break;
            case 54:
                return x.value = 6;
                break;
            case 55:
                return x.value = 7;
                break;
            case 56:
                return x.value = 8;
                break;
            case 97:
                return x.value = 1;
                break;
            case 98:
                return x.value = 2;
                break;
            case 99:
                return x.value = 3;
                break;
            case 100:
                return x.value = 4;
                break;
            case 101:
                return x.value = 5;
                break;
            case 102:
                return x.value = 6;
                break;
            case 103:
                return x.value = 7;
                break;
            case 104:
                return x.value = 8;
                break;
            case 13:
                document.getElementById("su").click();
                break;
            case 108:
                document.getElementById("su").click();
                break;
            default:
                alert("«Î ‰»Î1-8");
        }
        return x.value;
    }

};