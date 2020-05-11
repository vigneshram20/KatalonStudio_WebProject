set wsc = Createobject("WScript.Shell")
Do
'one minute
WScript.Sleep(60*1000)
wsc.SendKeys("{NUMLOCK}")
Loop