import{_ as Q,aH as v,Z as n,r as g,$ as S,ab as N,f as t,a3 as r,aI as y,F as I,a4 as P,a5 as _,a6 as c,a2 as x,aa as R,a7 as u,a8 as f,ad as b,G as B,aJ as E,aM as T,aK as V,C as z,aL as h,Q as O,aN as D,aO as U}from"./index.163e81c6.js";import{Q as F,b as C,a as K,e as A}from"./format.f63947d2.js";import{Q as p}from"./QTooltip.8dadf5a5.js";import{Q as Y}from"./QTable.b3ffb639.js";import{Q as w}from"./QForm.0ac9a22e.js";import{C as j}from"./ClosePopup.5dc9f167.js";const H={components:{KeyValue:v(()=>U(()=>import("./KeyValue.0941658d.js"),["assets/KeyValue.0941658d.js","assets/QTd.13c16205.js","assets/index.163e81c6.js","assets/index.749bada7.css","assets/format.f63947d2.js","assets/QTooltip.8dadf5a5.js","assets/QTable.b3ffb639.js","assets/ClosePopup.5dc9f167.js"]))},setup(){return{util:n,handler:g(null),table:g({rows:[],filters:{},columns:[],loading:!1,pagination:{page:1,rowsPerPage:30,sortBy:"producerId",descending:!1,count:!0}}),dialog:g({view:{show:!1,parameters:null},search:{show:!1}})}},created(){let e=this;e.handler=e.$route.query.handler,e.table.columns=[{name:"producerId",label:e.$t("label.producer_id"),field:"producerId",align:"left",sortable:!0},{name:"partition.topic",label:e.$t("label.topic"),field:"partition",align:"left",sortable:!0,format:function(l,s){return l.topic}},{name:"partition.index",label:e.$t("label.partition"),field:"partition",align:"left",sortable:!0,format:function(l,s){return l.index}},{name:"lastTimestamp",label:e.$t("label.last_timestamp"),field:"lastTimestamp",align:"left",sortable:!0,format:function(l,s){return n.isNumber(l)&&l>0?n.format.date(l,{format:"YYYY-MM-DD HH:mm:ss"}):""}},{name:"lastSequence",label:e.$t("label.last_sequence"),field:"lastSequence",align:"left"},{name:"producerEpoch",label:e.$t("label.producer_epoch"),field:"producerEpoch",align:"left"},{name:"coordinatorEpoch",label:e.$t("label.coordinator_epoch"),field:"coordinatorEpoch",align:"left"},{name:"currentTransactionStartOffset",label:e.$t("label.current_trx_start_offset"),field:"currentTransactionStartOffset",align:"left"}],e.on_refresh_click()},methods:{do_request(e){let l=this,{page:s,rowsPerPage:o,sortBy:k,descending:i}=l.get_pagination(e),m={name:l.handler,index:s,size:o,order:(i?"-":"")+k};Object.keys(l.table.filters).forEach(a=>{m[a]=l.table.filters[a]}),l.table.loading=!0,S.call({path:"/kafka/producers",params:m,onFinish(){l.table.loading=!1},onSuccess(a){if(n.isObject(a)){l.table.rows=n.isArray(a.data)?a.data:[];let d=l.table.pagination;if(d.page=a.index,d.rowsPerPage=a.size,n.isNumber(a.records))d.rowsNumber=a.records;else{let q=a.index*a.size;l.table.rows.length!==a.size?d.rowsNumber=q:d.rowsNumber=q+1}}}})},get_pagination(e){let l=this,s=e!=null&&e.pagination?e.pagination:l.table.pagination;return s?(l.table.pagination=s,s):l.table.pagination},on_refresh_click(){var l;let e=this;(l=e.table.rows)!=null&&l.length||e.table.pagination.page>1&&(e.table.pagination.page=1),e.do_request({pagination:e.table.pagination})},on_view_click(e){let l=this,s=[];for(const o of e.cols)s.push({label:o.label,value:n.isFunction(o.format)?o.format(e.row[o.field],e.row):e.row[o.field]});l.dialog.view={show:!0,parameters:{search:!1,rows:s}}},on_search_reset_click(){let e=this;e.table.filters={}},on_search_filter_click(){let e=this,l=e.table.filters;n.isString(l.producerId)&&l.producerId!==""||delete l.producerId,n.isString(l.topicName)&&l.topicName!==""||delete l.topicName,n.isString(l.partition)&&l.partition!==""||delete l.partition,e.do_request({pagination:e.table.pagination}),e.dialog.search.show=!1},on_search_dialog_click(){let e=this;e.dialog.search.show=!0}}},L={class:"full-width row flex-center text-accent q-gutter-sm"},M={class:"text-subtitle2"},G={class:"col-6 q-pr-xs text-left"},J={class:"col-6 q-pl-xs text-right"};function Z(e,l,s,o,k,i){const m=P("KeyValue");return _(),N(I,null,[t(Y,{class:"table-sticky-header q-ma-sm",rows:o.table.rows,columns:o.table.columns,loading:o.table.loading,selection:"single",dense:e.$q.screen.lt.md,"no-data-label":e.$t("error.data_not_available"),"rows-per-page-label":" ","rows-per-page-options":[10,20,30,40,50],"binary-state-sort":"",separator:"cell",pagination:o.table.pagination,"onUpdate:pagination":l[0]||(l[0]=a=>o.table.pagination=a),onRequest:i.do_request,bordered:""},{"top-right":r(()=>[t(c,{glossy:"",round:"",dense:"",class:"q-ma-none q-ml-md",color:"deep-orange",icon:"search",onClick:i.on_search_dialog_click},{default:r(()=>[Object.keys(o.table.filters).length?(_(),x(A,{key:0,class:"led-green",floating:""})):R("",!0),t(p,null,{default:r(()=>[u(f(e.$t("label.search")),1)]),_:1})]),_:1},8,["onClick"]),t(c,{glossy:"",round:"",dense:"",class:"q-ma-none q-ml-md",color:"indigo",icon:"refresh",loading:o.table.loading,onClick:i.on_refresh_click},{default:r(()=>[t(p,null,{default:r(()=>[u(f(e.$t("label.refresh")),1)]),_:1})]),_:1},8,["loading","onClick"])]),"no-data":r(({message:a})=>[b("div",L,[t(B,{size:"2em",name:"block"}),b("span",M,f(a),1)])]),"body-selection":r(a=>[t(c,{glossy:"",round:"",dense:"",size:"sm",class:"q-ma-none q-ml-xs q-mr-sm",color:"deep-purple",icon:"visibility",onClick:d=>i.on_view_click(a)},{default:r(()=>[t(p,null,{default:r(()=>[u(f(e.$t("label.view")),1)]),_:1})]),_:2},1032,["onClick"])]),_:1},8,["rows","columns","loading","dense","no-data-label","pagination","onRequest"]),t(y,{modelValue:o.dialog.view.show,"onUpdate:modelValue":l[1]||(l[1]=a=>o.dialog.view.show=a),"transition-show":"scale","transition-hide":"fade","backdrop-filter":"blur(2px)"},{default:r(()=>[t(m,{parameters:o.dialog.view.parameters},null,8,["parameters"])]),_:1},8,["modelValue"]),t(y,{modelValue:o.dialog.search.show,"onUpdate:modelValue":l[5]||(l[5]=a=>o.dialog.search.show=a),"transition-show":"scale","transition-hide":"fade","backdrop-filter":"blur(2px)",persistent:""},{default:r(()=>[t(E,{style:T("width: "+(e.$q.screen.lt.md?"100%;":"50%;"))},{default:r(()=>[t(V,{class:"q-pa-none header-main"},{default:r(()=>[t(F,{class:"q-pr-none"},{default:r(()=>[t(C,null,{default:r(()=>[t(K,{class:"text-h6 text-white"},{default:r(()=>[u(f(e.$t("label.search")),1)]),_:1})]),_:1}),t(C,{side:""},{default:r(()=>[z((_(),x(c,{class:"text-caption text-white q-pl-xs q-pr-xs q-mr-xs",flat:"",round:"",glossy:"",icon:"close"},{default:r(()=>[t(p,null,{default:r(()=>[u(f(e.$t("label.close")),1)]),_:1})]),_:1})),[[j]])]),_:1})]),_:1})]),_:1}),t(V,{style:{"max-height":"70vh"},class:"q-pa-xs q-mt-xs scroll"},{default:r(()=>[t(w,{onSubmit:i.on_search_filter_click,onReset:i.on_search_reset_click},{default:r(()=>[t(h,{modelValue:o.table.filters.producerId,"onUpdate:modelValue":l[2]||(l[2]=a=>o.table.filters.producerId=a),type:"text",label:e.$t("label.producer_id"),filled:"",class:"q-mb-xs"},null,8,["modelValue","label"])]),_:1},8,["onSubmit","onReset"]),t(w,{onSubmit:i.on_search_filter_click,onReset:i.on_search_reset_click},{default:r(()=>[t(h,{modelValue:o.table.filters.topicName,"onUpdate:modelValue":l[3]||(l[3]=a=>o.table.filters.topicName=a),type:"text",label:e.$t("label.topic"),filled:"",class:"q-mb-xs"},null,8,["modelValue","label"])]),_:1},8,["onSubmit","onReset"]),t(w,{onSubmit:i.on_search_filter_click,onReset:i.on_search_reset_click},{default:r(()=>[t(h,{modelValue:o.table.filters.partition,"onUpdate:modelValue":l[4]||(l[4]=a=>o.table.filters.partition=a),type:"text",label:e.$t("label.partition"),filled:"",class:"q-mb-xs"},null,8,["modelValue","label"])]),_:1},8,["onSubmit","onReset"])]),_:1}),t(O),t(D,{class:"row"},{default:r(()=>[b("div",G,[t(c,{label:e.$t("label.reset"),color:"orange","no-caps":"",glossy:"",onClick:i.on_search_reset_click},null,8,["label","onClick"])]),b("div",J,[t(c,{label:e.$t("label.filter"),color:"purple","no-caps":"",glossy:"",onClick:i.on_search_filter_click},null,8,["label","onClick"])])]),_:1})]),_:1},8,["style"])]),_:1},8,["modelValue"])],64)}var te=Q(H,[["render",Z]]);export{te as default};