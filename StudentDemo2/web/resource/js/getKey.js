function func(){
    var x;

    document.onkeydown = function (event) {
        var event = event || window.event;
        var code = event.keyCode || event.which;
        switch (code) {
            case 49:
                return x = 1;
                break;
            case 50:
                return x = 2;
                break;
            case 51:
                return x = 3;
                break;
            case 52:
                return x = 4;
                break;
            case 53:
                return x = 5;
                break;
            case 54:
                return x = 6;
                break;
            case 55:
                return x = 7;
                break;
            case 56:
                return x = 8;
                break;
            case 97:
                return x = 1;
                break;
            case 98:
                return x = 2;
                break;
            case 99:
                return x = 3;
                break;
            case 100:
                return x = 4;
                break;
            case 101:
                return x = 5;
                break;
            case 102:
                return x = 6;
                break;
            case 103:
                return x = 7;
                break;
            case 104:
                return x = 8;
                break;
            default:
                alert("ÇëÊäÈë1-8µÄÊı×Ö£¡");
        }

        return x;
    }

};