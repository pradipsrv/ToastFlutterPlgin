package com.easebuzz.sample_toast_plugin;

import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** SampleToastPlugin */
public class
SampleToastPlugin implements MethodCallHandler {
  /** Plugin registration. */
  public static Registrar registrar_;
  public static void registerWith(Registrar registrar) {
    registrar_= registrar;
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "sample_toast_plugin");
    channel.setMethodCallHandler(new SampleToastPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if(call.method.equals("showToast")){
        String msg = call.argument("message");
      Toast.makeText(registrar_.context(),msg, Toast.LENGTH_LONG).show();
    }else
    {
      result.notImplemented();
    }
  }
}
