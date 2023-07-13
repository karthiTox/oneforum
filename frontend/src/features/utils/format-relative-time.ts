export function formatRelativeTime(date: Date): string {
  const now = new Date();
  const diff = Math.floor((now.getTime() - date.getTime()) / 1000);

  if (diff < 60) {
    return `${diff} sec ago`;
  } else if (diff < 3600) {
    const mins = Math.floor(diff / 60);
    return `${mins} min ago`;
  } else if (diff < 86400) {
    const hours = Math.floor(diff / 3600);
    return `${hours} hour ago`;
  } else if (diff < 2592000) {
    const days = Math.floor(diff / 86400);
    return `${days} day ago`;
  } else if (diff < 31536000) {
    const months = Math.floor(diff / 2592000);
    return `${months} month ago`;
  } else {
    const years = Math.floor(diff / 31536000);
    return `${years} year ago`;
  }
}
