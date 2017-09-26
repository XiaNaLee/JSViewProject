//声明控件
var button = window.createButton("button")
var textView1 = window.createTextView("textView1")
var textView2 = window.createTextView("textView2")
var linearLayout = window.createLLayout("linearLayout")
var relativeLayout = window.createRLayout("relativeLayout")
var imageView = window.createImageView("imageView")

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


var hockeyTeam = {
     setData : function(url,pos) {
     var tv1 = window.findTextViewByTag("textView1")
     var iv = window.findImageViewByTag("imageView")
                  iv.setUrl(url)
                  tv1.setText(pos)
         }
}



