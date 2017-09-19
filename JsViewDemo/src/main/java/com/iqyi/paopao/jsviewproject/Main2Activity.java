package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);


        RelativeLayout layout= (RelativeLayout) findViewById(R.id.layout);
        layout.addView((View) runScript(getJsContent("test.js"), "java_call_js", new Object[]{this}));

        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(1,1);

        //text2.setText(runScript(JS_CALL_JAVA_FUNCTION, "Test", new String[] {}));
    }

   /* *//** Java执行js的方法 *//*
    private final String JAVA_CALL_JS_FUNCTION = getJsContent("test.js");

    *//** js调用Java中的方法 *//*
    private static final String JS_CALL_JAVA_FUNCTION = //
            "var ScriptAPI = java.lang.Class.forName(\"" + Main2Activity.class.getName() + "\", true, javaLoader);" + //
                    "var methodRead = ScriptAPI.getMethod(\"jsCallJava\", [java.lang.String]);" + //
                    "function jsCallJava(url) {return methodRead.invoke(null, url);}" + //
                    "function Test(){ return jsCallJava(); }";*/

    /**
     * 执行JS
     *
     * @param js js代码
     * @param functionName js方法名称
     * @param functionParams js方法参数
     * @return
     */
    public Object runScript(String js, String functionName, Object[] functionParams) {
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();

            ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(Main2Activity.this, scope));
            ScriptableObject.putProperty(scope, "javaLoader", Context.javaToJS(Main2Activity.class.getClassLoader(), scope));

            rhino.evaluateString(scope, js, "Main2Activity", 1, null);

            Function function = (Function) scope.get(functionName, scope);

            Object result = function.call(rhino, scope, scope, functionParams);
            if (result instanceof String) {
                return (String) result;
            } else if (result instanceof NativeJavaObject) {
                return ((NativeJavaObject) result).unwrap();
            } else if (result instanceof NativeObject) {
                return (String) ((NativeObject) result).getDefaultValue(String.class);
            }
            return result.toString();
        } finally {
            Context.exit();
        }
    }

    public static String jsCallJava(String url) {
        return "农民伯伯 js call Java Rhino";
    }

    private String getJsContent(String filename)
    {
        InputStreamReader reader;
        BufferedReader bufferedReader;
        try
        {
            reader = new InputStreamReader(getAssets().open(filename),"UTF-8");
            bufferedReader=new BufferedReader(reader);
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s=bufferedReader.readLine())!=null)
            {
                sb.append(s).append("\n");
            }
            return sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
