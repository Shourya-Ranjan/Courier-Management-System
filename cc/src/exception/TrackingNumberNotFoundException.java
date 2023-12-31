package exception;

public class TrackingNumberNotFoundException extends Exception {
	public TrackingNumberNotFoundException(long No) {
        super("Invalid Tracking Number "+No);
    }
}