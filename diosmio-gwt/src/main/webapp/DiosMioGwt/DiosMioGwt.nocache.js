function DiosMioGwt(){var O='',wb='" for "gwt:onLoadErrorFn"',ub='" for "gwt:onPropertyErrorFn"',hb='"><\/script>',Y='#',Rb='.cache.html',$='/',kb='//',Qb=':',ob='::',Zb='<script defer="defer">DiosMioGwt.onInjectionDone(\'DiosMioGwt\')<\/script>',gb='<script id="',rb='=',Z='?',tb='Bad handler "',Yb='DOMContentLoaded',P='DiosMioGwt',db='DiosMioGwt.nocache.js',nb='DiosMioGwt::',Pb="GWT module 'DiosMioGwt' may need to be (re)compiled",ib='SCRIPT',fb='__gwt_marker_DiosMioGwt',jb='base',bb='baseUrl',S='begin',R='bootstrap',ab='clear.cache.gif',qb='content',X='end',Jb='gecko',Kb='gecko1_8',T='gwt.codesvr=',U='gwt.hosted=',V='gwt.hybrid',Sb='gwt/chrome/chrome.css',vb='gwt:onLoadErrorFn',sb='gwt:onPropertyErrorFn',pb='gwt:property',Xb='head',Nb='hosted.html?DiosMioGwt',Wb='href',Ib='ie6',Hb='ie8',Gb='ie9',xb='iframe',_='img',yb="javascript:''",Tb='link',Mb='loadExternalRefs',lb='meta',Ab='moduleRequested',W='moduleStartup',Fb='msie',mb='name',Cb='opera',zb='position:absolute;width:0;height:0;border:none',Ub='rel',Eb='safari',cb='script',Ob='selectingPermutation',Q='startup',Vb='stylesheet',eb='undefined',Lb='unknown',Bb='user.agent',Db='webkit';var m=window,n=document,o=m.__gwtStatsEvent?function(a){return m.__gwtStatsEvent(a)}:null,p=m.__gwtStatsSessionId?m.__gwtStatsSessionId:null,q,r,s,t=O,u={},v=[],w=[],x=[],y=0,z,A;o&&o({moduleName:P,sessionId:p,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:S});if(!m.__gwt_stylesLoaded){m.__gwt_stylesLoaded={}}if(!m.__gwt_scriptsLoaded){m.__gwt_scriptsLoaded={}}function B(){var b=false;try{var c=m.location.search;return (c.indexOf(T)!=-1||(c.indexOf(U)!=-1||m.external&&m.external.gwtOnLoad))&&c.indexOf(V)==-1}catch(a){}B=function(){return b};return b}
function C(){if(q&&r){var b=n.getElementById(P);var c=b.contentWindow;if(B()){c.__gwt_getProperty=function(a){return G(a)}}DiosMioGwt=null;c.gwtOnLoad(z,P,t,y);o&&o({moduleName:P,sessionId:p,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:X})}}
function D(){function e(a){var b=a.lastIndexOf(Y);if(b==-1){b=a.length}var c=a.indexOf(Z);if(c==-1){c=a.length}var d=a.lastIndexOf($,Math.min(c,b));return d>=0?a.substring(0,d+1):O}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=n.createElement(_);b.src=a+ab;a=e(b.src)}return a}
function g(){var a=F(bb);if(a!=null){return a}return O}
function h(){var a=n.getElementsByTagName(cb);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(db)!=-1){return e(a[b].src)}}return O}
function i(){var a;if(typeof isBodyLoaded==eb||!isBodyLoaded()){var b=fb;var c;n.write(gb+b+hb);c=n.getElementById(b);a=c&&c.previousSibling;while(a&&a.tagName!=ib){a=a.previousSibling}if(c){c.parentNode.removeChild(c)}if(a&&a.src){return e(a.src)}}return O}
function j(){var a=n.getElementsByTagName(jb);if(a.length>0){return a[a.length-1].href}return O}
function k(){var a=n.location;return a.href==a.protocol+kb+a.host+a.pathname+a.search+a.hash}
var l=g();if(l==O){l=h()}if(l==O){l=i()}if(l==O){l=j()}if(l==O&&k()){l=e(n.location.href)}l=f(l);t=l;return l}
function E(){var b=document.getElementsByTagName(lb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(mb),g;if(f){f=f.replace(nb,O);if(f.indexOf(ob)>=0){continue}if(f==pb){g=e.getAttribute(qb);if(g){var h,i=g.indexOf(rb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=O}u[f]=h}}else if(f==sb){g=e.getAttribute(qb);if(g){try{A=eval(g)}catch(a){alert(tb+g+ub)}}}else if(f==vb){g=e.getAttribute(qb);if(g){try{z=eval(g)}catch(a){alert(tb+g+wb)}}}}}}
function F(a){var b=u[a];return b==null?null:b}
function G(a){var b=w[a](),c=v[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(A){A(a,d,b)}throw null}
var H;function I(){if(!H){H=true;var a=n.createElement(xb);a.src=yb;a.id=P;a.style.cssText=zb;a.tabIndex=-1;n.body.appendChild(a);o&&o({moduleName:P,sessionId:p,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:Ab});a.contentWindow.location.replace(t+K)}}
w[Bb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return b.indexOf(Cb)!=-1}())return Cb;if(function(){return b.indexOf(Db)!=-1}())return Eb;if(function(){return b.indexOf(Fb)!=-1&&n.documentMode>=9}())return Gb;if(function(){return b.indexOf(Fb)!=-1&&n.documentMode>=8}())return Hb;if(function(){var a=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(a&&a.length==3)return c(a)>=6000}())return Ib;if(function(){return b.indexOf(Jb)!=-1}())return Kb;return Lb};v[Bb]={gecko1_8:0,ie6:1,ie8:2,ie9:3,opera:4,safari:5};DiosMioGwt.onScriptLoad=function(){if(H){r=true;C()}};DiosMioGwt.onInjectionDone=function(){q=true;o&&o({moduleName:P,sessionId:p,subSystem:Q,evtGroup:Mb,millis:(new Date).getTime(),type:X});C()};E();D();var J;var K;if(B()){if(m.external&&(m.external.initModule&&m.external.initModule(P))){m.location.reload();return}K=Nb;J=O}o&&o({moduleName:P,sessionId:p,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:Ob});if(!B()){try{alert(Pb);return;var L=J.indexOf(Qb);if(L!=-1){y=Number(J.substring(L+1));J=J.substring(0,L)}K=J+Rb}catch(a){return}}var M;function N(){if(!s){s=true;if(!__gwt_stylesLoaded[Sb]){var a=n.createElement(Tb);__gwt_stylesLoaded[Sb]=a;a.setAttribute(Ub,Vb);a.setAttribute(Wb,t+Sb);n.getElementsByTagName(Xb)[0].appendChild(a)}C();if(n.removeEventListener){n.removeEventListener(Yb,N,false)}if(M){clearInterval(M)}}}
if(n.addEventListener){n.addEventListener(Yb,function(){I();N()},false)}var M=setInterval(function(){if(/loaded|complete/.test(n.readyState)){I();N()}},50);o&&o({moduleName:P,sessionId:p,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:X});o&&o({moduleName:P,sessionId:p,subSystem:Q,evtGroup:Mb,millis:(new Date).getTime(),type:S});n.write(Zb)}
DiosMioGwt();