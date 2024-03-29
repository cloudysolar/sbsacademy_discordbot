package com.stageroad0820.discordbot.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class GuildMusicManager {
	public final AudioPlayer audioPlayer;
	public final TrackScheduler scheduler;

	private final AudioPlayerSendHandler handler;

	public GuildMusicManager(AudioPlayerManager manager) {
		this.audioPlayer = manager.createPlayer();
		this.scheduler = new TrackScheduler(this.audioPlayer);
		this.audioPlayer.addListener(this.scheduler);
		this.handler = new AudioPlayerSendHandler(this.audioPlayer);
	}

	public AudioPlayerSendHandler getHandler() {
		return handler;
	}
}
