package com.surekam.cairngorm3.moduleTest.example.moduleA
{
	import com.surekam.cairngorm3.moduleTest.example.api.BroadCastMessage;
	import com.surekam.cairngorm3.moduleTest.example.api.ClearLogMessage;
	import com.surekam.cairngorm3.moduleTest.example.api.PingMessage;
	
	import mx.controls.Alert;

	public class ModuleAPM
	{
		[Bindable]
		public var data:String="";
		
		[Init]
		public function init():void
		{
			data+= "Parsley Context is initialized";
		}
		
		[MessageHandler(scope="local")]
		public function pingModuleAMessageHandler(message:PingMessage):void
		{
			data+= "Ping received!\n";
		}
		
		[MessageHandler(scope="local")]
		public function broadcastMessageHandler(message:BroadCastMessage):void
		{
		    Alert.show("收到信息");
			data+= "Broadcast received!";
		}
		
		[MessageHandler(scope="local")]
		public function clearLogMessageHandler(message:ClearLogMessage):void
		{
			data= "";
		}
		
		
		public function ModuleAPM()
		{
		}
	}
}