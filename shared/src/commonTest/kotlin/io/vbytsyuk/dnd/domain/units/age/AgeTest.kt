package io.vbytsyuk.dnd.domain.units.age

import io.vbytsyuk.dnd.domain.core.units.Age
import io.vbytsyuk.dnd.domain.core.units.years
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class AgeTest {

    // Creating an Age instance with a positive integer value
    @Test
    fun create_age_with_positive_value() {
        val age = Age(25)
        assertEquals(25, age.value)
    }

    // Creating a Range instance with valid start and end Age values
    @Test
    fun create_valid_range() {
        val start = Age(20)
        val end = Age(30)
        val range = Age.Range(start, end)
        assertEquals(start, range.start)
        assertEquals(end, range.end)
    }

    // Checking if an Age instance is within a valid Range
    @Test
    fun age_within_valid_range() {
        val start = Age(20)
        val end = Age(30)
        val range = Age.Range(start, end)
        val age = Age(25)
        assertTrue(age in range)
    }

    // Using the rangeTo operator to create a Range between two Age instances
    @Test
    fun range_to_operator_creates_range() {
        val start = Age(20)
        val end = Age(30)
        val range = start..end
        assertEquals(start, range.start)
        assertEquals(end, range.end)
    }

    // Using the years extension property to create an Age instance from an integer
    @Test
    fun years_extension_creates_age() {
        val age = 25.years
        assertEquals(25, age.value)
    }

    // Creating an Age instance with a zero value
    @Test
    fun create_age_with_zero_value() {
        val age = Age(0)
        assertEquals(0, age.value)
    }

    // Creating an Age instance with a negative value
    @Test
    fun create_age_with_negative_value() {
        assertFailsWith<IllegalArgumentException> { Age(-5) }
    }

    // Creating a Range instance where start Age is greater than end Age
    @Test
    fun create_invalid_range_throws_exception() {
        val start = Age(30)
        val end = Age(20)
        assertFailsWith<IllegalArgumentException> { Age.Range(start, end) }
    }

    // Checking if an Age instance is within an empty Range
    @Test
    fun age_within_empty_range() {
        val startEnd = Age(25)
        val range = startEnd..startEnd
        val age = Age(25)
        assertTrue(age in range)
    }

    // Using the rangeTo operator with identical Age instances
    @Test
    fun range_to_operator_with_identical_ages() {
        val age = Age(25)
        val range = age..age
        assertEquals(age, range.start)
        assertEquals(age, range.end)
    }

    // Verifying the Range contains operator works with boundary values
    @Test
    fun range_contains_boundary_values() {
        val start = Age(20)
        val end = Age(30)
        val range = Age.Range(start, end)
        assertTrue(Age(20) in range)
        assertTrue(Age(30) in range)
    }
}
