export function formatCurrency(amount) {
  return `$${amount.toFixed(2)}`;
}

export function capitalizeFirstLetter(str) {
  return str.charAt(0).toUpperCase() + str.slice(1);
}
