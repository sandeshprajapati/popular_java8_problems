Problem:

You are working for an e-commerce company, and you have the following data:

Products: Each product has an ID, name, price, category, and a list of reviews.

Reviews: Each review has a rating (1 to 5) and a timestamp.

You are tasked with generating a report on best-selling products and average product ratings, but with the following complexities:

Best-selling product: The product with the highest number of reviews in the last 3 months (or some specific time window).

Average rating: Calculate the average rating for each product, but only for reviews that have been made in the last 6 months.

Top categories: List the top 3 categories with the highest average price per product, where the price is calculated as the average price of all products in that category.

Finally, we need to filter out products that have a rating below 3.