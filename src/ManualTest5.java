import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherFactory;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;
import java.util.List;

public class ManualTest5 {
	
	public static void main(String args[]) {

		final LauncherDiscoveryRequest request = 
				LauncherDiscoveryRequestBuilder.request()
				.selectors(selectClass(TriangleClassifierTest5.class))
				.build();

		final Launcher launcher = LauncherFactory.create();
		final SummaryGeneratingListener listener = new SummaryGeneratingListener();

		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);

		TestExecutionSummary summary = listener.getSummary();
		long testFoundCount = summary.getTestsFoundCount();
		List<Failure> failures = summary.getFailures();
		System.out.println("getTestsSucceededCount(): " + summary.getTestsSucceededCount());
		failures.forEach(failure -> System.out.println("failure - " + failure.getException()));
	}

	@Test
	void exceptionTesting() {
		Executable closureContainingCodeToTest = () -> {throw new IllegalArgumentException("a message");};
		Throwable throwable = assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "a message");
		assertEquals("a message", throwable.getMessage());
	}
}