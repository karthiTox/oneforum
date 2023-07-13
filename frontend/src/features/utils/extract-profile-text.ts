export function extractProfileText(username: string) {
  if (username.length <= 0) {
    return `Aa`;
  }

  if (username.length == 1) {
    return username[0].toUpperCase() + username[0].toLowerCase();
  }

  if (username.length >= 2) {
    return username[0].toUpperCase() + username[1].toLowerCase();
  }

  throw `Aa`;
}
