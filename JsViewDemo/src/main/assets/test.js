

var button = window.createButton();
var textView = window.createTextView();

button.setText("button")
button.show()

textView.setText("text")
textView.show()

function setData(text1,text2){
   button.setText(text1)
   textView.setText(text2)
}
