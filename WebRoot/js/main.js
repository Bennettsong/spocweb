  $(document).ready(function () {
	$('#fullpage').fullpage({
	verticalCentered:false,
	anchors: ['firstPage', 'secondPage', '3rdPage', '4thpage', 'lastPage'],
	menu: '#menu',
	controlArrows:false,
	resize:false,
	scrollingSpeed:800,
	fitToSection:true,
	paddingTop:'50px',
	keyboardScrolling:true,
	loopTop:true,
	loopBottom:true,
	afterLoad: function(anchorLink, index){
		if (index ===2) {
			$('.carousel').carousel({
				interval: 3000
			});
		}
	}			
	});
	var a=$('#example_video_1').parent().width();
	var b=$('#unheight').height() *1.5;
	videojs("example_video_1", { "width": a, "height": b,  "controls": true, "autoplay": false, "preload": "auto" });				
	
	var iContentHeight = 0;
	contentAuto();
	//listContentAuto();
	teamContent();
	window.onresize = fnResize;

	function viewHeight(){
		return window.innerHeight || document.documentElement.clientHeight;
	}	
	function contentAuto(){
		iContentHeight = viewHeight() - 50;
		$("#team").css("height", iContentHeight + 'px');
	}
	
	function listContentAuto(){
		var mt = (iContentHeight - 520)/2;
		$("#teamContent").css("marginTop", mt + 'px');
	}
	
	function fnResize(){
		contentAuto();
		//listContentAuto();	
	}	
	
	
	function teamContent(){
		//oTeamContent3
		var oTeamContent3=document.getElementById("teamContent3");
		var aLi = oTeamContent3.getElementsByTagName('li');
		var oC = null;
		var w =190;
		var h = 448;
		var timer1 = null;
		var timer2 = null;
		create();
		bindList();
		function create(){
			var oUl = document.createElement('ul');
			for(var i=0;i<5;i++){
				
				var oLi = document.createElement('li');
				oLi.style.backgroundPosition =  -(i*w) +'px 0';
				oUl.appendChild(oLi);
					
			}
			oTeamContent3.appendChild(oUl);
		}
		function bindList(){
			
			oTeamContent3.onmouseleave = function(){
				removeCanvas();
				for(var i=0;i<aLi.length;i++){
					aLi[i].style.opacity = 1;
				}
			};
			
			for(var i=0;i<aLi.length;i++){
				aLi[i].index = i;
				aLi[i].onmouseover = function(){
					addCanvas();
					oC.style.left = this.index * w + 'px';
					for(var i=0;i<aLi.length;i++){
						aLi[i].style.opacity = 0.5;
					}
					this.style.opacity = 1;
				};
			}
		}
		function addCanvas(){
			if(!oC){
				oC = document.createElement('canvas');
				oC.id = 'canvasBubble';
				oC.width = w;
				oC.height = h;
				oTeamContent3.appendChild(oC);
				bindCanvas();
			}
		}
		function removeCanvas(){
			clearInterval(timer1);
			clearInterval(timer2);
			oTeamContent3.removeChild(oC);
			oC = null;
		}
		function bindCanvas(){
			var oGC = oC.getContext('2d');
	
			var setArr = [];   //瀛樺偍瑕佺粯鍒剁殑鎵�湁鍥惧舰鐨勬暟鎹�
			
			timer1 = setInterval(function(){
				
				oGC.clearRect(0,0,oC.width,oC.height);
				
				for(var i=0;i<setArr.length;i++){
					
					setArr[i].num += 5;
					
					setArr[i].x = setArr[i].startX - Math.sin(setArr[i].num*Math.PI/180)*setArr[i].step;
					setArr[i].y = setArr[i].startY - (setArr[i].num*Math.PI/180)*setArr[i].step;
					
					if( setArr[i].y < 50 ){
						setArr.splice(i,1);
					}
					
				}
				
				for(var i=0;i<setArr.length;i++){
					oGC.fillStyle = 'rgba('+setArr[i].c1+','+setArr[i].c2+','+setArr[i].c3+','+setArr[i].c4+')';
					oGC.beginPath();
						oGC.moveTo(setArr[i].x,setArr[i].y);
						oGC.arc(setArr[i].x,setArr[i].y,setArr[i].r,0,360*Math.PI/180);
					oGC.closePath();
					oGC.fill();
				}
				
			},1000/60);
			
			timer2 = setInterval(function(){
				
				var x = Math.random()*oC.width;
				var y = oC.height - 10;
				var r = Math.random()*6 + 2;
				var c1 = Math.round(Math.random()*255);
				var c2 = Math.round(Math.random()*255);
				var c3 = Math.round(Math.random()*255);
				var c4 = 1;
				var num = 0;
				var step = Math.random()*20 + 10;
				var startX = x;
				var startY = y;
				
				setArr.push({
					x : x,
					y : y,
					r : r,
					c1 : c1,
					c2 : c2,
					c3 : c3,
					c4 : c4,
					num : num,
					step : step,
					startX : x,
					startY : y
				});
				
			},100);
		}
	}	//oTeamContent3				
	 
});//(document).ready(function	



(function(window) {
	'use strict';

	// from: http://stackoverflow.com/a/21913575
	function getComputedTranslateY(obj) {
		if(!window.getComputedStyle) return;
		var style = getComputedStyle(obj),
			transform = style.transform || style.webkitTransform || style.mozTransform;
		var mat = transform.match(/^matrix3d\((.+)\)$/);
		if(mat) return parseFloat(mat[1].split(', ')[13]);
		mat = transform.match(/^matrix\((.+)\)$/);
		return mat ? parseFloat(mat[1].split(', ')[5]) : 0;
	}

	/**********************************************/
	/** https://gist.github.com/desandro/1866474 **/
	/**********************************************/
	var lastTime = 0;
	var prefixes = 'webkit moz ms o'.split(' ');
	// get unprefixed rAF and cAF, if present
	var requestAnimationFrame = window.requestAnimationFrame;
	var cancelAnimationFrame = window.cancelAnimationFrame;
	// loop through vendor prefixes and get prefixed rAF and cAF
	var prefix;
	for( var i = 0; i < prefixes.length; i++ ) {
		if ( requestAnimationFrame && cancelAnimationFrame ) {
			break;
		}
		prefix = prefixes[i];
		requestAnimationFrame = requestAnimationFrame || window[ prefix + 'RequestAnimationFrame' ];
		cancelAnimationFrame  = cancelAnimationFrame  || window[ prefix + 'CancelAnimationFrame' ] ||
		window[ prefix + 'CancelRequestAnimationFrame' ];
	}

	// fallback to setTimeout and clearTimeout if either request/cancel is not supported
	if ( !requestAnimationFrame || !cancelAnimationFrame ) {
		requestAnimationFrame = function( callback, element ) {
			var currTime = new Date().getTime();
			var timeToCall = Math.max( 0, 16 - ( currTime - lastTime ) );
			var id = window.setTimeout( function() {
				callback( currTime + timeToCall );
			}, timeToCall );
			lastTime = currTime + timeToCall;
			return id;
		};

		cancelAnimationFrame = function( id ) {
			window.clearTimeout( id );
		};
	}
	/**********************************************/
	/** https://gist.github.com/desandro/1866474 **/
	/**********************************************/

	var docElem = window.document.documentElement;
	
	// some helper functions
	function scrollY() { return window.pageYOffset || docElem.scrollTop; }
	function extend( a, b ) {
		for( var key in b ) { 
			if( b.hasOwnProperty( key ) ) {
				a[key] = b[key];
			}
		}
		return a;
	}
	
	/**
	 * Isometric grid obj
	 */
	function IsoGrid(el, options) {
		this.isolayerEl = el;
		
		this.options = extend( {}, this.options );
		extend( this.options, options );

		this.gridEl = this.isolayerEl.querySelector('.grid');

		// grid items
		this.gridItems = [].slice.call(this.gridEl.querySelectorAll('.grid__item'));
		this.gridItemsTotal = this.gridItems.length;
		
		this.didscroll = false;

		this._init();
	}

	IsoGrid.prototype.options = {
		// static or scrollable
		type: 'static',
		// grid perspective value
		perspective: 0,
		// grid transform
		transform: '',
		// each grid item animation (for the subitems)
		stackItemsAnimation : {
			// this follows the dynamics.js (https://github.com/michaelvillar/dynamics.js) animate fn syntax
			// properties (pos is the current subitem position)
			properties : function(pos) {
				return {
					translateZ: (pos+1) * 50
				};
			},
			// animation options (pos is the current subitem position); itemstotal is the total number of subitems
			options : function(pos, itemstotal) {
				return {
					type: dynamics.bezier,
					duration: 500,
					points: [{"x":0,"y":0,"cp":[{"x":0.2,"y":1}]},{"x":1,"y":1,"cp":[{"x":0.3,"y":1}]}]
				};
			}
		},
		// callback for loaded grid
		onGridLoaded : function() { return false; }	
	};

	IsoGrid.prototype._init = function() {
		var self = this;

		imagesLoaded(this.gridEl, function() {
			// initialize masonry
			self.msnry = new Masonry(self.gridEl, {
				itemSelector: '.grid__item',
				isFitWidth : true
			});
			
			// the isolayer div element will be positioned fixed and will have a transformation based on the values defined in the HTML (data-attrs for the isolayer div element)
			if( self.options.type === 'scrollable' ) {
				self.isolayerEl.style.position = 'fixed';	
			}
			
			self.isolayerEl.style.WebkitTransformStyle = self.isolayerEl.style.transformStyle = 'preserve-3d';

			var transformValue = self.options.perspective != 0 ? 'perspective(' + self.options.perspective + 'px) ' + self.options.transform : self.options.transform;
			self.isolayerEl.style.WebkitTransform = self.isolayerEl.style.transform = transformValue;
			
			// create the div element that will force the height for scrolling
			if( self.options.type === 'scrollable' ) {
				self._createPseudoScroller();
			}
			
			// init/bind events
			self._initEvents();

			// effects for loading grid elements:
			if( self.options.type === 'scrollable' ) {
				new AnimOnScroll(self.gridEl, {
					minDuration : 1,
					maxDuration : 1.2,
					viewportFactor : 0
				});
			}

			// grid is "loaded" (all images are loaded)
			self.options.onGridLoaded();
			classie.add(self.gridEl, 'grid--loaded');
		});
	};

	/**
	 * Creates the div element that will force the height for scrolling
	 */
	IsoGrid.prototype._createPseudoScroller = function() {
		// element that will force the height for scrolling
		this.pseudoScrollerEl = document.createElement('div');
		this.pseudoScrollerEl.className = 'pseudo-scroller';
		// insert it inside the main container (same level of isolayerEl)
		this.isolayerEl.parentNode.insertBefore(this.pseudoScrollerEl, this.isolayerEl);
		// set the height of the pseudoScroller (grid麓s height + additional space between the top of the rotated isolayerEl and the page - value set for the translation on the Y axis)
		this.pseudoScrollerEl.style.height = this.gridEl.offsetHeight + getComputedTranslateY(this.isolayerEl) * Math.sqrt(2) + 'px';	
	};

	/**
	 * Initialize/Bind events fn.
	 */
	IsoGrid.prototype._initEvents = function() {
		var self = this;

		var scrollHandler = function() {
				requestAnimationFrame(function() {
					if (!self.didscroll) {
						self.didscroll = true;
						self._scrollPage();
					}
				});
			},
			mouseenterHandler = function(ev) {
				self._expandSubItems(ev.target);
			},
			mouseleaveHandler = function(ev) {
				self._collapseSubItems(ev.target);
			};

		if( this.options.type === 'scrollable' ) {
			// update the transform (ty) on scroll
			window.addEventListener('scroll', scrollHandler, false);
			// on resize (layoutComplete for the masonry instance) recalculate height
			this.msnry.on('layoutComplete', function( laidOutItems ) {
				// reset the height of the pseudoScroller (grid麓s height + additional space between the top of the rotated isolayerEl and the page)
				self.pseudoScrollerEl.style.height = self.gridEl.offsetHeight + self.isolayerEl.offsetTop * Math.sqrt(2) + 'px';
				self._scrollPage();
			});
		}

		this.gridItems.forEach(function(item) {
			item.addEventListener('mouseenter', mouseenterHandler);
			item.addEventListener('mouseleave', mouseleaveHandler);
		});
	};

	IsoGrid.prototype._expandSubItems = function(item) {
		var self = this,
			itemLink = item.querySelector('a'),
			subItems = [].slice.call(itemLink.querySelectorAll('.layer')), 
			subItemsTotal = subItems.length;

		itemLink.style.zIndex = item.style.zIndex = this.gridItemsTotal;
		
		subItems.forEach(function(subitem, pos) {
			dynamics.stop(subitem);
			dynamics.animate(subitem, self.options.stackItemsAnimation.properties(pos), self.options.stackItemsAnimation.options(pos, subItemsTotal));
		});
	};

	IsoGrid.prototype._collapseSubItems = function(item) {
		var itemLink = item.querySelector('a');
		[].slice.call(itemLink.querySelectorAll('.layer')).forEach(function(subitem, pos) {
			dynamics.stop(subitem);
			dynamics.animate(subitem, {
				translateZ: 0 // enough to reset any transform value previously set
			}, {
				duration: 100,
				complete: function() {
					itemLink.style.zIndex = item.style.zIndex = 1;
				}
			})
		});
	};

	IsoGrid.prototype._scrollPage = function() {
		this.gridEl.style.WebkitTransform = this.gridEl.style.transform = 'translate3d(0,-' + scrollY() + 'px,0)';
		this.didscroll = false;
	};

	window.IsoGrid = IsoGrid;

})(window);

    $(function () {
		$('[data-toggle="tooltip"]').tooltip();
		var myPlayer = videojs("example_video_2");
		$('#myModal').on('show.bs.modal', function (e) {
			var str=(e.relatedTarget).getAttribute("data");
			var title=(e.relatedTarget).getAttribute("tle");
			$('#myModal h4').html(title);
			myPlayer.ready(function(){
				this.on("ended", function(){
					 //this.dispose(); 
					 this.pause();
				});
				this.src({type: "video/mp4", src: str});
				this.play();
			});
			myPlayer.preload();
		})
		
		$('#myModal').on('hidden.bs.modal', function (e) {
			//if(!myPlayer.paused)
				myPlayer.pause();
		})
		

			new IsoGrid(document.querySelector('.isolayer--deco4'), {
				perspective: 3000,
				transform : 'translate3d(-200px,-200px,0) scale3d(0.8,0.8,1) rotateY(50deg) rotateZ(-10deg)',
				stackItemsAnimation : {
					properties : function(pos) {
						return {
							rotateX: (pos+1) * -15
						};
					},
					options : function(pos, itemstotal) {
						return {
							type: dynamics.spring,
							delay: (itemstotal-pos-1)*30
						};
					}
				},
				onGridLoaded : function() {
					classie.add(document.body, 'grid-loaded');
				}
			});	
	})
