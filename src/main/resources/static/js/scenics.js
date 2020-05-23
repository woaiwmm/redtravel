//景点展示 滑动
$(function () {
  $('a[href*=#]:not([href=#])').click(function () {
    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {

      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
      if (target.length) {
        $('html,body').animate({
          scrollTop: target.offset().top
        }, 1000);
        return false;
      }
    }
  });
});

//demo

$(document).ready(function () {
  $("#owl-demo").owlCarousel({
    autoPlay: 4000,
    items: 4,
    itemsDesktop: [1199, 3],
    itemsDesktopSmall: [979, 3]
  })

});

$(document).ready(function () {

  var owl = $("#owl-demo");

  owl.owlCarousel();

  // Custom Navigation Events
  $(".next").click(function () {
    owl.trigger('owl.next');
  })
  $(".prev").click(function () {
    owl.trigger('owl.prev');
  })

});



$(function () {

  // Instantiate MixItUp:

  $('#Container').mixItUp();

});

jQuery(function ($) {
  // fancybox
  $(".fancybox").fancybox({
    modal: true, // disable regular nav and close buttons
    // add buttons helper (requires buttons helper js and css files)
    helpers: {
      buttons: {}
    }
  });
  // filter selector
  $(".filter").on("click", function () {
    var $this = $(this);
    // if we click the active tab, do nothing
    if (!$this.hasClass("active")) {
      $(".filter").removeClass("active");
      $this.addClass("active"); // set the active tab
      // get the data-rel value from selected tab and set as filter
      var $filter = $this.data("rel");
      // if we select view all, return to initial settings and show all
      $filter == 'all' ?
        $(".fancybox")
          .attr("data-fancybox-group", "gallery")
          .not(":visible")
          .fadeIn()
        : // otherwise
        $(".fancybox")
          .fadeOut(0)
          .filter(function () {
            // set data-filter value as the data-rel value of selected tab
            return $(this).data("filter") == $filter;
          })
          // set data-fancybox-group and show filtered elements
          .attr("data-fancybox-group", $filter)
          .fadeIn(1000);
    } // if
  }); // on
}); // ready

//===============texitimonial=====================


$('.quotes').quovolver({
  equalHeight= true
});

