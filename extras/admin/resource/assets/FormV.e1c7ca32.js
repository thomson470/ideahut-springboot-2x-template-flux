import{Q as v,b as p,a as y}from"./format.650a3fa7.js";import{Q}from"./QTooltip.3cd33127.js";import{_ as q,r as c,Y as m,a4 as d,a1 as u,a2 as a,f as s,aI as x,a6 as h,a7 as _,C as w,a5 as V,aa as I,F as C,ab as k,aJ as F,aK as S,aH as B}from"./index.cf0e6694.js";import{C as D}from"./ClosePopup.fb083e6c.js";import{g as n}from"./Index.896d75d9.js";import"./QSpace.1021ecfc.js";import"./QTable.4293fe89.js";import"./QBadge.062f3943.js";import"./QInnerLoading.1086a0a2.js";import"./QSpinnerGears.0625f03b.js";const $={props:["parameters"],setup(){return{title:c(null),fields:c([])}},created(){let t=this,f=n.get.object(t.parameters),r=n.get.object(f.form),o=n.get.object(f.data);t.title=r.title,t.fields=[];let i=!1;for(const e of r.fields){let l=m.getFieldValue(e.name,o);!i&&r.id.fields.includes(e.name)&&(i=!0),m.isFunction(e.format)&&(l=e.format(l,o)),t.fields.push({label:e.label,value:l})}if(!i){let e=n.id.toPk(r.id,o);m.isDefined(e)&&e!==null&&t.fields.splice(0,0,{label:"ID",value:e})}}};function j(t,f,r,o,i,e){return d(),u(B,{style:S("width: "+(t.$q.screen.lt.md?"100%;":"50%;"))},{default:a(()=>[s(x,{class:"q-pa-none header-main"},{default:a(()=>[s(v,{class:"q-pr-none"},{default:a(()=>[s(p,null,{default:a(()=>[s(y,{class:"text-h6 text-white"},{default:a(()=>[h(_(o.title),1)]),_:1})]),_:1}),s(p,{side:""},{default:a(()=>[w((d(),u(V,{class:"text-caption text-white q-pl-xs q-pr-xs q-mr-xs",flat:"",round:"",glossy:"",icon:"close"},{default:a(()=>[s(Q,null,{default:a(()=>[h(_(t.$t("label.close")),1)]),_:1})]),_:1})),[[D]])]),_:1})]),_:1})]),_:1}),s(x,{style:{"max-height":"80vh"},class:"q-pa-xs q-mt-xs scroll"},{default:a(()=>[(d(!0),I(C,null,k(o.fields,(l,b)=>(d(),u(F,{key:b,type:"text",label:l.label,modelValue:l.value,"onUpdate:modelValue":g=>l.value=g,readonly:"",filled:"",autogrow:"",class:"q-mb-xs",style:{"max-height":"200px",overflow:"scroll"}},null,8,["label","modelValue","onUpdate:modelValue"]))),128))]),_:1})]),_:1},8,["style"])}var Y=q($,[["render",j]]);export{Y as default};