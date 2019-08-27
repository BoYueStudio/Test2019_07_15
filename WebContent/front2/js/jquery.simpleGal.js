/****************************************************************
 *																*		
 * 						      代码库							*
 *                        www.dmaku.com							*
 *       		  努力创建完善、持续更新插件以及模板			*
 * 																*
****************************************************************/
(function($){

  $.fn.extend({

    simpleGal: function (options) {

      var defaults = {
        p_mainImage: ".placeholder"
      };

      options = $.extend(defaults, options);

      return this.each(function () {

        var thumbnail = $(this).find("a"),
            p_mainImage = $(this).siblings().find(options.p_mainImage);

        thumbnail.on("click", function (e) {
          e.preventDefault();
          var galleryImage = $(this).attr("href");
          p_mainImage.attr("src", galleryImage);
        });

      });

    }

  });

})(jQuery);
