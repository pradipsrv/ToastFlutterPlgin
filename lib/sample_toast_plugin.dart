import 'dart:async';

import 'package:flutter/services.dart';

class SampleToastPlugin {
  static MethodChannel _channel = MethodChannel('sample_toast_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static showToast(String message) {
    _channel.invokeMethod("showToast", {"message": message});
  }


  static openAcitivity() {
    _channel.invokeMethod("showActivity");
  }

  static paywitheasebuzz() {
    _channel.invokeMethod("payWithEasebuzz");
  }


}
