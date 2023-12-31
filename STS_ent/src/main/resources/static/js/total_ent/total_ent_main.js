$(document).ready(function() {
  // 슬라이드 쇼 초기화 코드
  var slideContainer = document.getElementsByClassName("slide-group")[0];
  var slides = slideContainer.getElementsByClassName("slide");
  var currentSlide = 0;
  var interval;

  // 슬라이드 쇼 시작 함수
  function startSlideShow() {
    interval = setInterval(function() {
      showNextSlide();
    }, 4000);
  }

  function showSlide(index) {
    for (var i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
    }
    slides[index].style.display = "block";
  }

  // 슬라이드 쇼 정지 함수
  function stopSlideShow() {
    clearInterval(interval);
  }

  // 다음 슬라이드로 이동하는 함수
  function showNextSlide() {
    slides[currentSlide].style.display = "none";
    currentSlide = (currentSlide + 1) % slides.length;
    slides[currentSlide].style.display = "block";
  }

  // 슬라이드 쇼 시작
  startSlideShow();

  $('.slider').each(function() {
    // 이전 버튼과 다음 버튼에 대한 클릭 이벤트 핸들러 추가
    var $nav = $(this).find('.slide-nav');
    $nav.find('.prev').on('click', function(event) {
      event.preventDefault();
      showNextSlide();
      stopSlideShow();
    });
    $nav.find('.next').on('click', function(event) {
      event.preventDefault();
      showNextSlide();
      stopSlideShow();
    });

    // 슬라이드 버튼에 대한 클릭 이벤트 핸들러 추가
    var $slides = $(this).find('.slide');
    var buttonArray = [];

    $.each($slides, function(index) {
      var $button = $('<button type="button" class="slide-btn">&bull;</button>');
      if (index === currentSlide) {
        $button.addClass('active');
      }
      $button.on('click', function() {
        slides[currentSlide].style.display = "none";
        currentSlide = index;
        slides[currentSlide].style.display = "block";
        stopSlideShow();
      }).appendTo('.slide-buttons');
      buttonArray.push($button);
    });
  });

  // total_ent_main별 이미지
  // total_ent_main 이미지 슬라이드
  var url = new URL(window.location.href);
  var category = url.searchParams.get("category");

  if (category === "1") {
    slideContainer.innerHTML = `
      <div class="slide slide-1">
        <img src="/img/concert/c슬라이드1.jpg" alt="">
      </div>
      <div class="slide slide-2">
        <img src="/img/concert/c슬라이드2.jpg" alt="">
      </div>
      <div class="slide slide-3">
        <img src="/img/concert/c슬라이드3.jpg" alt="">
      </div>
      <div class="slide slide-4">
        <img src="/img/concert/c슬라이드4.jpg" alt="">
      </div>
      <div class="slide slide-5">
        <img src="/img/concert/c슬라이드5.jpg" alt="">
      </div>
      <div class="slide slide-6">
        <img src="/img/concert/c슬라이드6.jpg" alt="">
      </div>
      <div class="slide slide-7">
        <img src="/img/concert/c슬라이드7.jpg" alt="">
      </div>
      <div class="slide slide-8">
        <img src="/img/concert/c슬라이드8.jpg" alt="">
      </div>
      <div class="slide slide-9">
        <img src="/img/concert/c슬라이드9.jpg" alt="">
      </div>`;
  } else if (category === "2") {
    slideContainer.innerHTML = `
      <div class="slide slide-1">
        <img src="/img/theater/th슬라이드1.jpg" alt="">
      </div>
      <div class="slide slide-2">
        <img src="/img/theater/th슬라이드2.jpg" alt="">
      </div>
      <div class="slide slide-3">
        <img src="/img/theater/th슬라이드3.jpg" alt="">
      </div>
      <div class="slide slide-4">
        <img src="/img/theater/th슬라이드4.jpg" alt="">
      </div>
      <div class="slide slide-5">
        <img src="/img/theater/th슬라이드5.jpg" alt="">
      </div>
      <div class="slide slide-6">
        <img src="/img/theater/th슬라이드6.jpg" alt="">
      </div>
      <div class="slide slide-7">
        <img src="/img/theater/th슬라이드7.jpg" alt="">
      </div>
      <div class="slide slide-8">
        <img src="/img/theater/th슬라이드8.jpg" alt="">
      </div>
      <div class="slide slide-9">
        <img src="/img/theater/th슬라이드9.jpg" alt="">
      </div>`;
  } else if (category === "3") {
    slideContainer.innerHTML = `
      <div class="slide slide-1">
        <img src="/img/museum/m슬라이드1.jpg" alt="">
      </div>
      <div class="slide slide-2">
        <img src="/img/museum/m슬라이드2.jpg" alt="">
      </div>
      <div class="slide slide-3">
        <img src="/img/museum/m슬라이드3.jpg" alt="">
      </div>
      <div class="slide slide-4">
        <img src="/img/museum/m슬라이드4.jpg" alt="">
      </div>
      <div class="slide slide-5">
        <img src="/img/museum/m슬라이드5.jpg" alt="">
      </div>
      <div class="slide slide-6">
        <img src="/img/museum/m슬라이드6.jpg" alt="">
      </div>
      <div class="slide slide-7">
        <img src="/img/museum/m슬라이드7.jpg" alt="">
      </div>
      <div class="slide slide-8">
        <img src="/img/museum/m슬라이드8.jpg" alt="">
      </div>
      <div class="slide slide-9">
        <img src="/img/museum/m슬라이드9.jpg" alt="">
      </div>`;
  }
});