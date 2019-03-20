import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:sample_toast_plugin/sample_toast_plugin.dart';

void main() {
  const MethodChannel channel = MethodChannel('sample_toast_plugin');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await SampleToastPlugin.platformVersion, '42');
  });
}
