package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;

/**
 * @author Nick Hamnett
 * @author Maryam Moussavi
 * @version 2020-03-24
 *
 */
class LinkedListTests {
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
	}

	/**
	 * Test the linked list is not empty.
	 */
	@Test
	void testIsNotEmpty() {
		linkedList.append("A");
		linkedList.append("B");
		linkedList.append("C");
		assertFalse(this.linkedList.isEmpty());
	}

	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		/**
		 * Linked list should now be:
		 *
		 * a -> b -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");

		/**
		 * Linked list should now be:
		 *
		 * d -> c -> b -> a
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("d", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("c", this.linkedList.retrieve(1));

		// Test the third node value is c
		assertEquals("b", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("a", this.linkedList.retrieve(3));
	}

	/**
	 * Tests inserting node at valid index.
	 */
	@Test
	void testInsertNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.insert("e", 2);

		/**
		 * Linked list should now be:
		 *
		 * a -> b -> e -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));

		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
	}

	/**
	 * Tests inserting node at first index.
	 */
	@Test
	void testInsertFirstNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.insert("e", 0);

		/**
		 * Linked list should now be:
		 *
		 * e -> a -> b -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("e", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("a", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("b", this.linkedList.retrieve(2));

		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
	}

	/**
	 * Tests inserting node at first index.
	 */
	@Test
	void testInsertLastNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.insert("e", 4);

		/**
		 * Linked list should now be:
		 *
		 * a -> b -> c -> d -> e
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("c", this.linkedList.retrieve(2));

		// Test the third node value is c
		assertEquals("d", this.linkedList.retrieve(3));

		// Test the fourth node value is d
		assertEquals("e", this.linkedList.retrieve(4));
	}

	/**
	 * Tests inserting node at an invalid index.
	 */
	@Test
	void testNotInsertNode() throws IndexOutOfBoundsException {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		try {
			this.linkedList.insert("e", 5);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}

	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.replace("e", 2);

		/**
		 * Linked list should now be:
		 *
		 * a -> b -> e -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests replacing first existing nodes data.
	 */
	@Test
	void testReplaceFirstNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.replace("e", 0);

		/**
		 * Linked list should now be:
		 *
		 * e -> b -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("e", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("c", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests replacing last existing nodes data.
	 */
	@Test
	void testReplaceLastNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.replace("e", 3);

		/**
		 * Linked list should now be:
		 *
		 * a -> b -> c -> e
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("c", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("e", this.linkedList.retrieve(3));
	}

	/**
	 * Tests replacing non-existing nodes data.
	 */
	@Test
	void testNotReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		try {
			this.linkedList.replace("e", 2);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.delete(2);

		/**
		 * Linked list should now be:
		 *
		 * a -> b -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(2));
	}

	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteOneNode() {
		this.linkedList.append("a");

		this.linkedList.delete(0);

		assertTrue(this.linkedList.isEmpty());
	}

	/**
	 * Tests deleting node from outside the size of the linked list.
	 */
	@Test
	void testNotDeleteNode() throws IndexOutOfBoundsException {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		try {
			this.linkedList.delete(4);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}

	/**
	 * Tests clearing the linked list.
	 */
	@Test
	void testClearList() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		this.linkedList.clear();

		assertTrue(this.linkedList.isEmpty());
	}

	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		/**
		 * Linked list should now be:
		 *
		 * a -> b -> c -> d
		 */

		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);

		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);

		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}

	/**
	 * Tests retrieving the size of the linked list
	 */
	@Test
	void testSize() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		assertEquals(4, this.linkedList.size());
	}

	/**
	 * Tests retrieving the data from a given index
	 */
	@Test
	void testRetrieve() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests retrieving the data from a given index outside of the size of the list
	 */
	@Test
	void testNotRetrieve() throws IndexOutOfBoundsException {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		try {
			this.linkedList.retrieve(3);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Tests retrieving the index of a given data
	 */
	@Test
	void testIndexOf() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		assertEquals(2, this.linkedList.indexOf("c"));
	}

	/**
	 * Tests the index of a given data if the data is not present on a node in the
	 * linked list
	 */
	@Test
	void testNotIndexOf() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		assertEquals(-1, this.linkedList.indexOf("x"));
	}

	/**
	 * Tests contains method for if it will return true if something is on the list.
	 */
	@Test
	void testContains() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		assertTrue(this.linkedList.contains("c"));
	}

	/**
	 * Tests contains method for if it will return false if something is not on the
	 * list.
	 */
	@Test
	void testNotContains() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		assertFalse(this.linkedList.contains("x"));
	}
}
