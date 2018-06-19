package com.jackie.classbook.util;


import com.jackie.classbook.dto.response.AccountLoginRespDTO;

public class TrackHolder {

	final static TrackHolder holder = new TrackHolder();
	final static ThreadLocal<Tracker> cache = new ThreadLocal<Tracker>();

	public static Tracker getTracker() {
		return cache.get() == null ? holder.new Tracker() : cache.get();
	}

	public static void set(long accountId, AccountLoginRespDTO accountLoginRespDTO) {
		cache.set(holder.new Tracker(accountId, accountLoginRespDTO));
	}

	public static void remove() {
		cache.remove();
	}

	public class Tracker {
		long accountId;
		AccountLoginRespDTO accountLoginRespDTO;

		public Tracker() {
		}

		public Tracker(long accountId, AccountLoginRespDTO accountLoginRespDTO) {
			this.accountId=accountId;
			this.accountLoginRespDTO=accountLoginRespDTO;
		}

		public long getAccountId() {
			return accountId;
		}

		public void setAccountId(long accountId) {
			this.accountId = accountId;
		}

		public AccountLoginRespDTO getAccountLoginRespDTO() {
			return accountLoginRespDTO;
		}

		public void setAccountLoginRespDTO(AccountLoginRespDTO accountLoginRespDTO) {
			this.accountLoginRespDTO = accountLoginRespDTO;
		}
	}
}
