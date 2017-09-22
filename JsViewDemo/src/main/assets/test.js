//声明控件
var button = window.createButton();
var textView = window.createTextView();
var linearLayout = window.createLLayout();
var relativeLayout = window.createRLayout();


relativeLayout.setSize(MATCH_PARENT,WRAP_CONTENT)
relativeLayout.setBgColor("#FF4040")


textView.setText("text")
textView.addRule(ALIGN_PARENT_RIGHT);
relativeLayout.addView(textView.getViewId())


button.setText("button")
button.click(function click(){
    button.setText("被点击了"+button.getViewId())
 })
button.addRuleBySub(LEFT_OF,textView.getViewId())
relativeLayout.addView(button.getViewId())


relativeLayout.generateView()




// linearLayout.setSize(MATCH_PARENT,200)
// linearLayout.setBgColor("#FF4040")
// //generateView这个方法被调用会将button添加到ViewGroup上展示出来(手机界面能看到)，不添加就不会展示
// linearLayout.generateView()


// var buttonId = button.getViewId();
// button.setText("button")

// //button的点击事件
// linearLayout.addView(buttonId);



function setData(text1,text2){
   button.setText(text1)
   textView.setText(text2)
}
