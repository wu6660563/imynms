package com.surekam.cairngorm3.moduleTest.example.moduleC
{
	import com.surekam.cairngorm3.moduleTest.example.api.ClearLogMessage;
	import com.surekam.cairngorm3.moduleTest.example.api.PongMessage;

	public class ModuleCPM
	{
		[Bindable]
		public var data:String="";
		
		[Init]
		public function initialize():void
		{
			data+= "Parsley Context is initialized\n";
		}
		
		[MessageHandler(scope="local")]
		public function pongMessageHandler(message:PongMessage):void
		{
			data+= "Pong received!\n";
		}
		
		[MessageHandler(scope="local")]
		public function clearLogMessageHandler(message:ClearLogMessage):void
		{
			data= "";
		}
		public function ModuleCPM()
		{
		}
	}
}