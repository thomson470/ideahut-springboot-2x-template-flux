import{Q as I,b as S,a as D}from"./format.650a3fa7.js";import{Q as O}from"./QTooltip.3cd33127.js";import{_ as P,r as q,Y as V,a4 as s,a1 as n,a2 as o,f as l,aI as T,a6 as N,a7 as b,C as y,a5 as c,aa as p,F,ab as W,aJ as i,G as g,aF as d,a9 as m,Q as v,aL as L,aK as A,aH as R}from"./index.cf0e6694.js";import{Q,a as h,b as $,c as x,d as C,e as B}from"./QTabPanels.473810ef.js";import{Q as E}from"./QPopupProxy.eabe6561.js";import{a as w}from"./QTable.4293fe89.js";import{Q as z}from"./QForm.ce34ad94.js";import{C as _}from"./ClosePopup.fb083e6c.js";import"./QResizeObserver.d7289347.js";import"./TouchPan.7cb95415.js";const G={props:["parameters"],emits:["close"],setup(){return{filters:q([]),template:q({}),enums:q({}),options:q({})}},created(){let t=this,u=t.parameters||{};t.filters=V.isArray(u.filters)?u.filters:[],t.template=V.isObject(u.template)?u.template:{},t.enums={},V.isObject(t.template.enums)&&Object.keys(t.template.enums).forEach(r=>{t.enums[r]=[null].concat(t.template.enums[r])}),t.options={},V.isObject(t.template.options)&&Object.keys(t.template.options).forEach(r=>{t.options[r]=[null].concat(t.template.options[r])})},methods:{on_reset_click(){let t=this;for(const u of t.filters)delete u.value,delete u.value2},on_filter_click(){let t=this;for(const u of t.filters)V.isDefined(u.value)&&u.value===null&&delete u.value,V.isDefined(u.value2)&&u.value2===null&&delete u.value2;t.$emit("close",t.filters)}}},H={key:0},J={key:0,class:"q-mb-xs row"},K={key:1,class:"q-mb-xs"},Y={key:0,class:"row"},M={class:"bg-primary"},X={class:"q-pa-xs bg-white row"},Z={class:"col-6 text-left"},f={class:"col-6 text-right"},ee={class:"bg-primary"},ae={class:"q-pa-xs bg-white row"},le={class:"col-6 text-left"},oe={class:"col-6 text-right"},te={class:"bg-primary"},se={class:"q-pa-xs bg-white row"},de={class:"col-6 text-left"},ne={class:"col-6 text-right"},ue={key:2,class:"q-mb-xs"},me={key:0,class:"row"},pe={key:3,class:"q-mb-xs"},ce={key:4,class:"q-mb-xs"},ie={key:0,class:"row"},be={class:"col-6 q-pr-xs text-left"},ye={class:"col-6 q-pl-xs text-right"};function ve(t,u,r,k,_e,U){return s(),n(R,{style:A("width: "+(t.$q.screen.lt.md?"100%;":"50%;"))},{default:o(()=>[l(T,{class:"q-pa-none header-main"},{default:o(()=>[l(I,{class:"q-pr-none"},{default:o(()=>[l(S,null,{default:o(()=>[l(D,{class:"text-h6 text-white"},{default:o(()=>[N(b(t.$t("label.search")),1)]),_:1})]),_:1}),l(S,{side:""},{default:o(()=>[y((s(),n(c,{class:"text-caption text-white q-pl-xs q-pr-xs q-mr-xs",flat:"",round:"",glossy:"",icon:"close"},{default:o(()=>[l(O,null,{default:o(()=>[N(b(t.$t("label.close")),1)]),_:1})]),_:1})),[[_]])]),_:1})]),_:1})]),_:1}),l(T,{style:{"max-height":"70vh"},class:"q-pa-xs q-mt-xs scroll"},{default:o(()=>[(s(!0),p(F,null,W(k.filters,(e,j)=>(s(),p("div",{key:j,class:"q-mb-xs"},[l(z,{onSubmit:U.on_filter_click,onReset:U.on_reset_click},{default:o(()=>[e.type==="words"?(s(),p("div",H,[e.condition==="BETWEEN"?(s(),p("div",J,[l(i,{type:"text",label:e.label,modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,filled:"",autogrow:"",class:"col-6 q-pr-xs",style:{"max-height":"200px",overflow:"scroll"}},null,8,["label","modelValue","onUpdate:modelValue"]),l(i,{type:"text",label:e.label,modelValue:e.value2,"onUpdate:modelValue":a=>e.value2=a,filled:"",autogrow:"",class:"col-6 q-pl-xs",style:{"max-height":"200px",overflow:"scroll"}},null,8,["label","modelValue","onUpdate:modelValue"])])):(s(),n(i,{key:1,type:"text",label:e.label,modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,filled:"",autogrow:"",style:{"max-height":"200px",overflow:"scroll"}},null,8,["label","modelValue","onUpdate:modelValue"]))])):e.type==="datetime"||e.type==="date"||e.type==="time"?(s(),p("div",K,[e.condition==="BETWEEN"?(s(),p("div",Y,[l(i,{type:"text",label:e.label,modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,filled:"",class:"col-6 q-pr-xs"},{append:o(()=>[l(g,{name:e.type==="time"?"schedule":e.type==="date"?"calendar_month":"event",class:"cursor-pointer"},{default:o(()=>[l(E,{"transition-show":"scale","transition-hide":"scale",cover:"",onBeforeShow:a=>{e.proxy_value=e.value,e.tab=e.type==="time"?"time":"date"}},{default:o(()=>[d("div",M,[l(Q,{modelValue:e.tab,"onUpdate:modelValue":a=>e.tab=a,class:"bg-primary text-grey-5 shadow-2 text-subtitle2",align:"justify","no-caps":"","indicator-color":"transparent","active-color":"white"},{default:o(()=>[e.type==="datetime"||e.type==="date"?(s(),n(h,{key:0,name:"date"},{default:o(()=>[d("span",null,b(t.$t("label.date")),1)]),_:1})):m("",!0),e.type==="datetime"||e.type==="time"?(s(),n(h,{key:1,name:"time"},{default:o(()=>[d("span",null,b(t.$t("label.time")),1)]),_:1})):m("",!0)]),_:2},1032,["modelValue","onUpdate:modelValue"]),l(v),l($,{modelValue:e.tab,"onUpdate:modelValue":a=>e.tab=a},{default:o(()=>[e.type==="datetime"||e.type==="date"?(s(),n(x,{key:0,name:"date",class:"q-pa-none"},{default:o(()=>[l(C,{modelValue:e.proxy_value,"onUpdate:modelValue":a=>e.proxy_value=a,mask:e.pattern,square:""},null,8,["modelValue","onUpdate:modelValue","mask"])]),_:2},1024)):m("",!0),e.type==="datetime"||e.type==="time"?(s(),n(x,{key:1,name:"time",class:"q-pa-none"},{default:o(()=>[l(B,{modelValue:e.proxy_value,"onUpdate:modelValue":a=>e.proxy_value=a,mask:e.pattern,format24h:"",square:""},null,8,["modelValue","onUpdate:modelValue","mask"])]),_:2},1024)):m("",!0)]),_:2},1032,["modelValue","onUpdate:modelValue"]),l(v),d("div",X,[d("div",Z,[y(l(c,{label:t.$t("label.cancel"),color:"red","no-caps":""},null,8,["label"]),[[_]])]),d("div",f,[y(l(c,{label:t.$t("label.ok"),color:"secondary","no-caps":"",onClick:a=>e.value=e.proxy_value},null,8,["label","onClick"]),[[_]])])])])]),_:2},1032,["onBeforeShow"])]),_:2},1032,["name"])]),_:2},1032,["label","modelValue","onUpdate:modelValue"]),l(i,{type:"text",label:e.label,modelValue:e.value2,"onUpdate:modelValue":a=>e.value2=a,filled:"",class:"col-6 q-pr-xs"},{append:o(()=>[l(g,{name:e.type==="time"?"schedule":e.type==="date"?"calendar_month":"event",class:"cursor-pointer"},{default:o(()=>[l(E,{"transition-show":"scale","transition-hide":"scale",cover:"",onBeforeShow:a=>{e.proxy_value2=e.value2,e.tab2=e.type==="time"?"time":"date"}},{default:o(()=>[d("div",ee,[l(Q,{modelValue:e.tab2,"onUpdate:modelValue":a=>e.tab2=a,class:"bg-primary text-grey-5 shadow-2 text-subtitle2","no-caps":"","indicator-color":"transparent","active-color":"white"},{default:o(()=>[e.type==="datetime"||e.type==="date"?(s(),n(h,{key:0,name:"date"},{default:o(()=>[d("span",null,b(t.$t("label.date")),1)]),_:1})):m("",!0),e.type==="datetime"||e.type==="time"?(s(),n(h,{key:1,name:"time"},{default:o(()=>[d("span",null,b(t.$t("label.time")),1)]),_:1})):m("",!0)]),_:2},1032,["modelValue","onUpdate:modelValue"]),l(v),l($,{modelValue:e.tab2,"onUpdate:modelValue":a=>e.tab2=a},{default:o(()=>[e.type==="datetime"||e.type==="date"?(s(),n(x,{key:0,name:"date",class:"q-pa-none"},{default:o(()=>[l(C,{modelValue:e.proxy_value2,"onUpdate:modelValue":a=>e.proxy_value2=a,mask:e.pattern,square:""},null,8,["modelValue","onUpdate:modelValue","mask"])]),_:2},1024)):m("",!0),e.type==="datetime"||e.type==="time"?(s(),n(x,{key:1,name:"time",class:"q-pa-none"},{default:o(()=>[l(B,{modelValue:e.proxy_value2,"onUpdate:modelValue":a=>e.proxy_value2=a,mask:e.pattern,format24h:"",square:""},null,8,["modelValue","onUpdate:modelValue","mask"])]),_:2},1024)):m("",!0)]),_:2},1032,["modelValue","onUpdate:modelValue"]),l(v),d("div",ae,[d("div",le,[y(l(c,{label:t.$t("label.cancel"),color:"red","no-caps":""},null,8,["label"]),[[_]])]),d("div",oe,[y(l(c,{label:t.$t("label.ok"),color:"secondary","no-caps":"",onClick:a=>e.value2=e.proxy_value2},null,8,["label","onClick"]),[[_]])])])])]),_:2},1032,["onBeforeShow"])]),_:2},1032,["name"])]),_:2},1032,["label","modelValue","onUpdate:modelValue"])])):(s(),n(i,{key:1,type:"text",label:e.label,modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,filled:""},{append:o(()=>[l(g,{name:e.type==="time"?"schedule":e.type==="date"?"calendar_month":"event",class:"cursor-pointer"},{default:o(()=>[l(E,{"transition-show":"scale","transition-hide":"scale",cover:"",onBeforeShow:a=>{e.proxy_value=e.value,e.tab=e.type==="time"?"time":"date"}},{default:o(()=>[d("div",te,[l(Q,{modelValue:e.tab,"onUpdate:modelValue":a=>e.tab=a,class:"bg-primary text-grey-5 shadow-2 text-subtitle2","no-caps":"","indicator-color":"transparent","active-color":"white"},{default:o(()=>[e.type==="datetime"||e.type==="date"?(s(),n(h,{key:0,name:"date"},{default:o(()=>[d("span",null,b(t.$t("label.date")),1)]),_:1})):m("",!0),e.type==="datetime"||e.type==="time"?(s(),n(h,{key:1,name:"time"},{default:o(()=>[d("span",null,b(t.$t("label.time")),1)]),_:1})):m("",!0)]),_:2},1032,["modelValue","onUpdate:modelValue"]),l(v),l($,{modelValue:e.tab,"onUpdate:modelValue":a=>e.tab=a},{default:o(()=>[e.type==="datetime"||e.type==="date"?(s(),n(x,{key:0,name:"date",class:"q-pa-none"},{default:o(()=>[l(C,{modelValue:e.proxy_value,"onUpdate:modelValue":a=>e.proxy_value=a,mask:e.pattern,square:""},null,8,["modelValue","onUpdate:modelValue","mask"])]),_:2},1024)):m("",!0),e.type==="datetime"||e.type==="time"?(s(),n(x,{key:1,name:"time",class:"q-pa-none"},{default:o(()=>[l(B,{modelValue:e.proxy_value,"onUpdate:modelValue":a=>e.proxy_value=a,mask:e.pattern,format24h:"",square:""},null,8,["modelValue","onUpdate:modelValue","mask"])]),_:2},1024)):m("",!0)]),_:2},1032,["modelValue","onUpdate:modelValue"]),l(v),d("div",se,[d("div",de,[y(l(c,{label:t.$t("label.cancel"),color:"red","no-caps":""},null,8,["label"]),[[_]])]),d("div",ne,[y(l(c,{label:t.$t("label.ok"),color:"secondary","no-caps":"",onClick:a=>e.value=e.proxy_value},null,8,["label","onClick"]),[[_]])])])])]),_:2},1032,["onBeforeShow"])]),_:2},1032,["name"])]),_:2},1032,["label","modelValue","onUpdate:modelValue"]))])):e.type==="option"?(s(),p("div",ue,[e.condition==="BETWEEN"?(s(),p("div",me,[l(w,{modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,label:e.label,options:k.options[e.option],"option-value":"value","option-label":"label","emit-value":"","map-options":"",filled:"",class:"col-6 q-pl-xs"},null,8,["modelValue","onUpdate:modelValue","label","options"]),l(w,{modelValue:e.value2,"onUpdate:modelValue":a=>e.value2=a,label:e.label,options:k.options[e.option],"option-value":"value","option-label":"label","emit-value":"","map-options":"",filled:"",class:"col-6 q-pl-xs"},null,8,["modelValue","onUpdate:modelValue","label","options"])])):(s(),n(w,{key:1,modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,label:e.label,options:k.options[e.option],"option-value":"value","option-label":"label","emit-value":"","map-options":"",filled:""},null,8,["modelValue","onUpdate:modelValue","label","options"]))])):e.type==="enum"?(s(),p("div",pe,[l(w,{modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,label:e.label,options:k.enums[e.enum],"option-value":"value","option-label":"label","emit-value":"","map-options":"",filled:""},null,8,["modelValue","onUpdate:modelValue","label","options"])])):(s(),p("div",ce,[e.condition==="BETWEEN"?(s(),p("div",ie,[l(i,{type:"text",label:e.label,modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,filled:"",class:"col-6 q-pr-xs"},null,8,["label","modelValue","onUpdate:modelValue"]),l(i,{type:"text",label:e.label,modelValue:e.value2,"onUpdate:modelValue":a=>e.value2=a,filled:"",class:"col-6 q-pl-xs"},null,8,["label","modelValue","onUpdate:modelValue"])])):e.type?(s(),n(i,{key:1,type:"text",label:e.label,modelValue:e.value,"onUpdate:modelValue":a=>e.value=a,filled:""},null,8,["label","modelValue","onUpdate:modelValue"])):m("",!0)]))]),_:2},1032,["onSubmit","onReset"])]))),128))]),_:1}),l(v),l(L,{class:"row"},{default:o(()=>[d("div",be,[l(c,{label:t.$t("label.reset"),color:"orange","no-caps":"",glossy:"",onClick:U.on_reset_click},null,8,["label","onClick"])]),d("div",ye,[l(c,{label:t.$t("label.filter"),color:"purple","no-caps":"",glossy:"",onClick:U.on_filter_click},null,8,["label","onClick"])])]),_:1})]),_:1},8,["style"])}var $e=P(G,[["render",ve]]);export{$e as default};