How can I ensure that my code, program, or software is functional and secure?

I ensure my software is functional by building  clear requirements and verifying behavior with automated unit tests. In Project One, I used JUnit to test both the Contact model and the ContactService, focusing on normal cases and edge cases like null values, invalid field lengths, and duplicate IDs. Writing tests helped me confirm the code works as expected and quickly catch regressions when changes were made. To keep software secure, I apply input validation early, enforce constraints consistently, and use testing to confirm invalid inputs are rejected. While unit tests don’t replace full security testing, they help enforce safe, predictable behavior and reduce the risk of unexpected failures.

How do I interpret user needs and incorporate them into a program?

I start by translating user needs into specific, testable requirements. For this course, the requirements defined what fields a contact must have, what constraints those fields follow, and what operations the service must support (add, update, delete, and retrieve). I incorporated those needs by implementing validation rules directly in the classes and then building tests that prove each requirement is met. If a requirement is unclear, I break it into smaller behaviors and confirm each one with a test case, which helps ensure the final program matches what the user is asking for.

How do I approach designing software?

I approach software design by separating responsibilities, keeping the code maintainable, and planning around testing. For example, Contact focuses on holding valid data, while ContactService manages business operations and rules like uniqueness and updates. I design with testing in mind by keeping methods small, predictable, and easy to verify through unit tests. This approach supports quality assurance because the design naturally encourages automation, repeatable validation, and easier debugging when issues appear.
