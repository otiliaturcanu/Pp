package org.example

import java.io.File

fun main(args: Array<String>) {
    var recorder = mutableListOf<SyslogRecord>()

    File("syslog").forEachLine{ it ->
        var a = it.split("debian")
        var b = a[1].split(":")
        val pid = "\\b[0-9]+\\b".toRegex()
        var ans = pid.find(b[0])//valoare in value a fregexului gasit de la regex clasa
        var c = b[0].split("[")
        var s:SyslogRecord
        if (ans != null) {
            if (ans.value != null && ans.value != "")
            { s = SyslogRecord(a[0], "debian", c[0], ans?.value?.toInt(), b[1])
                recorder.add(s)
            }
            else {
                s = SyslogRecord(a[0], "debian", c[0], null, b[1])
                recorder.add(s)
            }
        }
    }
    var m = mutableMapOf<String, MutableList<SyslogRecord>>()//map-cheievaloare Stringul este systemd iar Mutable sunt toate ob cu systemd
    recorder.asSequence()//face secv din toate
        .forEach { if(m.containsKey(it.aplication)){
            m[it.aplication]?.add(it)//adauga
        }
        else{
            var l = mutableListOf<SyslogRecord>()
            l.add(it)//toata linia
            m.put(it.aplication, l)
        }
        }

    m.values.asSequence()//o mapa are keys and values, fiec values la noi e o lista
        .forEach { it ->
            it.asSequence()
                .sortedBy { it.entry }//entry ce e dupa:
        }

    recorder.asSequence()//recorder are tot
        .filter { it.pid != null }//filter conditie la sequence
        .forEach { println(it) }
}

