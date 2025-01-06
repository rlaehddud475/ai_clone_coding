document.addEventListener('DOMContentLoaded', function() {
    // 각 약관 토글 버튼에 클릭 이벤트 추가
    var toggleButtons = document.querySelectorAll('.toggle-terms-btn');

    toggleButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            var targetContentId = button.id.replace('terms-toggle', 'terms-content');
            var content = document.getElementById(targetContentId);

            // 내용 펼치기/접기
            content.classList.toggle('show');
        });
    });
});
