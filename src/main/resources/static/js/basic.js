$(document).ready(function () {
    $('.check').change(function (message) {
        let fixedExtensionValue = $(this).val();
        let isChecked = $(this).is(':checked');

        if (isChecked) {
            $.ajax({
                url: '/api/v1/extension',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({extensionName : fixedExtensionValue}),
                success: function (res) {
                    alert(res.extensionName + "확장자가 추가되었습니다.");
                },
                error: function (error) {
                    alert(error.responseText);
                }
            });
        } else {
            $.ajax({
                url: 'api/v1/extension/delete',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify({extensionName : fixedExtensionValue}),
                success: function (res) {
                    alert(res.extensionName + "확장자가 삭제되었습니다.");
                },
                error: function (error) {
                    alert(error.responseText);
                }
            });
        }
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
        });
    });
});

$(document).ready(function () {
    $.ajax({
        url: 'api/v1/custom-extension/all',
        type: 'GET',
        success: function (data) {
            data.forEach(function (res) {
                $('#saveExtension').append(
                    '<div class="extensionItem">' +
                    res.extensionName +
                    ' <button class="deleteButton">X</button></div>'
                );
            });
        },
        error: function (error) {
            alert(error.responseText);
        }
    });

    $('#saveExtension').on('click', '.deleteButton', function () {
        let extensionName = $(this).parent().text().replace(" X", ""); // 확장자 이름 가져오기

        $.ajax({
            url: 'api/v1/custom-extension/delete',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify({
                extensionName: extensionName
            }),
            success: function (res) {
                alert(res.extensionName + " 확장자가 삭제되었습니다.");
                $(this).parent().remove(); // 화면에서 해당 항목 제거
            }.bind(this), // `this`를 바인딩하여 올바른 요소를 가리키도록 함
            error: function (error) {
                alert(error.responseText);
            }
        });
    });
});