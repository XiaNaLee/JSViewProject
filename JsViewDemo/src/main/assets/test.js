//声明控件
var button = window.createButton()
var textView1 = window.createTextView()
var textView2 = window.createTextView()
var linearLayout = window.createLLayout()
var relativeLayout = window.createRLayout()
var imageView = window.createImageView()

relativeLayout.setSize(MATCH_PARENT,WRAP_CONTENT)
relativeLayout.setBgColor("#FF4040")

imageView.setSize(100,100)
imageView.setRoundedCorners(true)
relativeLayout.addView(imageView.getViewId())


textView1.setText("范冰冰")
textView1.setTextSize(19)
textView1.setTextColor("#FFFFFF")
textView1.setRMargin(10,10,0,0)
textView1.addRuleBySub(RIGHT_OF,imageView.getViewId());
relativeLayout.addView(textView1.getViewId())


textView2.setText("粉丝: 70.9万 粉丝: 70.9万")
textView2.setTextSize(14)
textView2.setTextColor("#FFFFFF")
textView2.setRMargin(10,10,0,0)
textView2.addRuleBySub(RIGHT_OF,imageView.getViewId());
textView2.addRuleBySub(BELOW,textView1.getViewId());
relativeLayout.addView(textView2.getViewId())


button.setText("加入")
button.click(function click(){
    button.setText("被点击了"+button.getViewId())
 })
button.setRMargin(0,20,0,0)
button.addRule(ALIGN_PARENT_RIGHT)
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


function setData(url){
  imageView.setUrl(url)
}
