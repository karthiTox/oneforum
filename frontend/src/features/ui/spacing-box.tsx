
interface Props {
  className?: string;
}

export function SpacingBox({className}:Props) {
  return <div className={ className ?? `mb-4`}></div>
}