$(document).ready(function () {
    $('.check').change(function (message) {
        let checkValue = $(this).val();
        let isChecked = $(this).is(':checked');

        $.ajax({
            url: '/api/v1/extension',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                extensionName: checkValue,
                bool: isChecked
            }),
            success: function (res) {
                alert(res.extensionName + "확장자가 추가되었습니다.");
            },
            error: function (error) {
                alert(error.responseText);
            }
        });
    });
});

$(document).ready(function () {
    $('#btn').click(function () {
        let customExtensionValue = $('input[type="text"]').val();

        if (customExtensionValue === "") {
            alert("확장자를 입력해주세요");
            return
        }

        $.ajax({
            url: 'api/v1/custom-extension',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                extensionName: customExtensionValue
            }),
            success: function (res) {
                alert(res.extensionName + "확장자가 추가되었습니다.");
            },
            error: function (error) {
                alert(error.responseText);
            }
        })
    })
})