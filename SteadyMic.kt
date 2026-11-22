if (commMode) {
    val context = ctx
    if (context != null) {
        runCatching {
            val a = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
            am = a
            oldMode = a.mode
            oldSpeaker = a.isSpeakerphoneOn

            a.mode = AudioManager.MODE_IN_COMMUNICATION
            a.isSpeakerphoneOn = true

            val max = a.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL)
            if (a.getStreamVolume(AudioManager.STREAM_VOICE_CALL) < max * 6 / 10) {
                a.setStreamVolume(AudioManager.STREAM_VOICE_CALL, max * 8 / 10, 0)
            }
        }
    }
}
