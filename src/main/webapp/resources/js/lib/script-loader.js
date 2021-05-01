$(document).ready(function () {

    if (document.URL.search("eccdReport") > 1)
        scriptLoader("/resources/js/organization/eccdReport.js");

});

var scriptLoader = function (url) {
    $.ajax(
        {
            type: "GET",
            url: url,
            dataType: "script",
            cache: false
        });
};

