public class ThreadSafety {

    /**
     * Thread Safety :
     * 1. Mutual exclusion: At a time, only one thread should be allowed in a critical section to avoid any kind of race condition.
     *                      This is achieved using synchronized keyword
     * 2. Visibility : Whenever a thread operates on a shared resource, all the other threads that are also operating on the same resources
     *                 will be seeing the latest set of changes. Every thread that is listening on the shared resource will have the
     *                 visibility of all the changes done on that resource
     *
     *
     *   Synchronized block : Offers both consistency as well as visibility (strong consistency)
     *   Volatile keyword: Offers only visibility but no consistency (faster than your synchronized)
     */


}
