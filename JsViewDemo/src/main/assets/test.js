//function java_call_js(name){ return name+' java call js Rhino'; }

function java_call_js(context){
var layout=new android.widget.RelativeLayout(context)
var layoutParams=new android.widget.RelativeLayout.LayoutParams(-2,-2)
var text=new android.widget.TextView(context)
text.setText("你是傻逼吗")
layout.addView(text,layoutParams)
return layout;
}
