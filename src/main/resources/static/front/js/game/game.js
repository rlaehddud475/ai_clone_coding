document.addEventListener("DOMContentLoaded", function() {
    const slides = document.querySelectorAll('.slide');
    const prevButton = document.querySelector('.prev');
    const nextButton = document.querySelector('.next');
    const totalSlides = slides.length;

    let currentSlide = 0;

    // 슬라이드 표시 함수
    function showSlide(index) {
        if (index >= totalSlides) currentSlide = 0;   // 마지막 슬라이드일 때 첫 번째로 돌아감
        if (index < 0) currentSlide = totalSlides - 1; // 첫 번째 슬라이드일 때 마지막으로 돌아감

        // 슬라이드들을 전환
        const slideWidth = slides[0].offsetWidth;
        const newTransformValue = -slideWidth * currentSlide;
        document.querySelector('.slides').style.transform = `translateX(${newTransformValue}px)`;
    }

    // 이전 슬라이드로 이동
    function prevSlide() {
        currentSlide--;
        showSlide(currentSlide);
    }

    // 다음 슬라이드로 이동
    function nextSlide() {
        currentSlide++;
        showSlide(currentSlide);
    }

    // 버튼 클릭 이벤트 리스너
    nextButton.addEventListener('click', nextSlide);
    prevButton.addEventListener('click', prevSlide);

    // 초기 슬라이드 표시
    showSlide(currentSlide);

    // 자동 슬라이드 전환 (5초마다)
    setInterval(nextSlide, 5000);
});
