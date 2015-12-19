package com.surekam.cairngorm3.moduleTest.example.api
{
	import com.adobe.cairngorm.module.ModuleIdMetadata;

	public class PingMessage
	{
		private var _moduleId:String;
		public function PingMessage( moduleId:String)
		{
			this._moduleId = moduleId;
		}
		
		[ModuleId]
		public function get moduleId():String
		{
			return _moduleId;
		}
	}
}